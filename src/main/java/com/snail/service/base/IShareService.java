package com.snail.service.base;

import com.snail.pojo.domain.ShareTag;
import com.snail.pojo.form.ShareForm;
import com.snail.pojo.form.ShareTagForm;
import com.snail.pojo.vo.ShareTagVo;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

/**
 * 用户分享Service接口
 *
 * @author panyuanyuan on 2017/10/15.
 */
public interface IShareService {

    /**
     * 分页查询分享列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    Map<String, Object> listShares(Integer pageNo, Integer pageSize);

    /**
     * 添加文章, 返回文章的html文章链接
     *
     * @param shareForm
     */
    String insertShare(ShareForm shareForm, HttpSession session);

    /**
     * 查询标签列表
     *
     * @return 标签列表
     */
    List<ShareTagVo> getTagList();

    /**
     * 更新标签
     *
     * @param tagForm 更新标签内容
     * @return 更新结果
     */
    boolean updateTag(ShareTagForm tagForm);

    /**
     * 添加标签
     *
     * @param tagForm 添加的标签内容
     * @return 添加结果
     */
    boolean insertTag(ShareTagForm tagForm);

    /**
     * 根据标签ID查询标签
     *
     * @param id 标签ID
     * @return 查询到的标签
     */
    ShareTag selectTagById(Integer id);
}
