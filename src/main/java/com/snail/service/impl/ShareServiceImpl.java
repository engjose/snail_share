package com.snail.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.snail.commen.ExceptionCode;
import com.snail.commen.ResponseCode;
import com.snail.dao.ShareContentMapper;
import com.snail.dao.ShareInfoMapper;
import com.snail.dao.ShareTagMapper;
import com.snail.exception.SnailClientException;
import com.snail.interceptor.ParameterThreadLocal;
import com.snail.pojo.domain.*;
import com.snail.pojo.form.ShareForm;
import com.snail.pojo.form.ShareTagForm;
import com.snail.pojo.vo.ShareTagVo;
import com.snail.service.base.IShareService;
import com.snail.util.FTPUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户分享Service接口
 *
 * @author panyuanyuan on 2017/10/15.
 */
@Service
@Slf4j
public class ShareServiceImpl implements IShareService {

    /** article存放的地址前缀 */
    private static final String SHARE_URL_PREFIX = "http://article.thinkerol.com/";

    /** 设置文章头,防止乱码 */
    private static final String HTML_HEAD = "<!DOCTYPE html>\n"
        + "<html lang=\"en\">\n"
        + "<head>\n"
        + "    <meta charset=\"UTF-8\">\n"
        + "    <title>Document</title>\n"
        + "</head>\n"
        + "<body>\n";

    /** 设置文章尾 */
    private static final String HTML_FOOT = "\n</body>\n"
        + "<html>";

    @Autowired
    private ShareInfoMapper shareInfoMapper;

    @Autowired
    private ShareContentMapper shareContentMapper;

    @Autowired
    private ShareTagMapper shareTagMapper;

    @Override
    public Map<String, Object> listShares(Integer pageNo, Integer pageSize) {
        //查询文章列表信息
        ShareInfoExample shareInfoExample = new ShareInfoExample();
        shareInfoExample.setOrderByClause("create_at desc");
        PageHelper.startPage(pageNo, pageSize);
        List<ShareInfo> shareInfos = shareInfoMapper.selectByExample(shareInfoExample);
        for (ShareInfo shareInfo: shareInfos) {
            shareInfo.setShareUrl(SHARE_URL_PREFIX + shareInfo.getShareUrl());
        }
        PageInfo<ShareInfo> pageInfo = new PageInfo(shareInfos);

        Map<String, Object> result = Maps.newHashMap();
        result.put("list", pageInfo.getList());
        result.put("total", pageInfo.getTotal());
        return result;
    }

    @Override
    public String insertShare(@NonNull ShareForm shareForm, HttpSession session) {
        Integer contentId = insertContent(shareForm.getContent());

        String shareUrl = creactShareHtml(contentId, shareForm.getContent(), session);

        ShareInfo shareInfo = new ShareInfo();
        BeanUtils.copyProperties(shareForm, shareInfo);
        shareInfo.setContentId(contentId);
        shareInfo.setShareUrl(shareUrl);
        shareInfo.setScanCount(0);
        shareInfo.setCollectCount(0);
        shareInfo.setCommentCount(0);
        shareInfo.setStarCount(0);
        shareInfo.setCreateAt(new Date());
        shareInfo.setUpdateAt(new Date());
        shareInfo.setUserId(ParameterThreadLocal.getUid().get());
        shareInfo.setLoginName(ParameterThreadLocal.getLoginName().get());
        shareInfoMapper.insert(shareInfo);

        return shareUrl;
    }

    /**
     * 查询标签列表
     *
     * @return 标签列表
     */
    @Override
    public List<ShareTagVo> getTagList() {
        ShareTagExample example = new ShareTagExample();
        example.setOrderByClause("tag_name");
        List<ShareTag> shareTags = shareTagMapper.selectByExample(example);
        List<ShareTagVo> shareTagVos = new ArrayList<>(16);
        for(ShareTag shareTag : shareTags) {
            ShareTagVo shareTagVo = new ShareTagVo();
            BeanUtils.copyProperties(shareTag, shareTagVo);
            shareTagVos.add(shareTagVo);
        }

        return shareTagVos;
    }

    /**
     * 更新标签
     *
     * @param tagForm 更新标签内容
     * @return 更新结果false：失败，true：成功
     */
    @Override
    public boolean updateTag(ShareTagForm tagForm) {
        if(tagForm.getId() == null) {
            log.error("参数错误：{}", "被更新的标签ID不能为空！");
            throw new SnailClientException(ExceptionCode.REQUEST_ARGUMENT_NOT_BE_NULL.getCode(), ExceptionCode.REQUEST_ARGUMENT_NOT_BE_NULL.getDescription());
        }
        ShareTag tag = new ShareTag();
        BeanUtils.copyProperties(tagForm, tag);
        ShareTagExample example = new ShareTagExample();
        example.createCriteria().andIdEqualTo(tag.getId());
        int result = shareTagMapper.updateByExampleSelective(tag, example);

        return result > 0;
    }

    /**
     * 添加标签
     *
     * @param tagForm 添加的标签内容
     * @return 添加结果
     */
    @Override
    public boolean insertTag(ShareTagForm tagForm) {
        ShareTag tag = new ShareTag();
        Date date = new Date();
        tag.setCreatAt(date);
        tag.setUpdateAt(date);
        BeanUtils.copyProperties(tagForm, tag);
        int result = shareTagMapper.insert(tag);

        return result > 0;
    }

    /**
     * 根据标签ID查询标签
     *
     * @param id 标签ID
     * @return 查询到的标签
     */
    @Override
    public ShareTag selectTagById(Integer id) {
        if(id == null) {
            log.error("参数错误：{}", "被查询的标签ID不能为空！");
            throw new SnailClientException(ExceptionCode.REQUEST_ARGUMENT_NOT_BE_NULL.getCode(), ExceptionCode.REQUEST_ARGUMENT_NOT_BE_NULL.getDescription());
        }
        ShareTagExample example = new ShareTagExample();
        example.createCriteria().andIdEqualTo(id);

        return shareTagMapper.selectByExample(example).get(0);
    }

    /**
     * 保存文章内容信息
     *
     * @param content
     * @return
     */
    private Integer insertContent(String content) {
        ShareContent record = new ShareContent();
        record.setContent(content);
        record.setCreateAt(new Date());
        record.setUpdateAt(new Date());

        shareContentMapper.insertSelective(record);
        return record.getId();
    }

    /**
     * 创建文章的HTML类型并进行保存
     *
     * @param contentId
     * @param content
     * @return
     */
    private String creactShareHtml(Integer contentId, String content, HttpSession session) {
        content = HTML_HEAD + content + HTML_FOOT;
        String realPath = session.getServletContext().getRealPath("/share");
        File dir = new File(realPath);
        if (!dir.exists() && dir.isDirectory()) {
            dir.mkdirs();
        }

        File htmlFile = new File(dir,contentId + ".html");
        FileOutputStream htmlOutputStream = null;
        try {
            htmlFile.createNewFile();
            htmlOutputStream = new FileOutputStream(htmlFile);
            htmlOutputStream.write(content.getBytes("UTF-8"));
        } catch (IOException e) {
            log.error("生成Html文件异常");
            e.printStackTrace();
        } finally {
            if(htmlOutputStream != null) {
                try {
                    htmlOutputStream.close();
                } catch (IOException e) {
                    log.error("IO异常");
                    e.printStackTrace();
                }
            }
        }

        //上传文件到FTP
        FTPUtil.uploadFile(Lists.newArrayList(htmlFile));
        //删除本地文件
        htmlFile.delete();

        return contentId + ".html";
    }

}
