package com.snail.controller.backend;

import com.snail.commen.ResponseCode;
import com.snail.commen.ResultMap;
import com.snail.interceptor.ParameterThreadLocal;
import com.snail.pojo.domain.ShareTag;
import com.snail.pojo.form.ShareForm;
import com.snail.pojo.form.ShareTagForm;
import com.snail.service.base.IShareService;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Panyuanyuan
 * @Date: Created in 下午3:04 2017/10/21
 * @Description: 分享文章的后台管理
 */
@RestController
@RequestMapping("/shareMgr")
@CrossOrigin
public class ShareMgrController {

    @Autowired
    private IShareService iShareService;

    /**
     * 添加文章
     *
     * @param shareForm
     */
    @PostMapping(value = "/articles")
    public ResultMap addShare(@RequestBody ShareForm shareForm, HttpSession session) {
        return ResultMap.getResultMap(200, "添加成功", iShareService.insertShare(shareForm, session));
    }

    /**
     * 查询标签列表
     *
     * @return 标签列表
     */
    @GetMapping(value = "/tags")
    public ResultMap getTagList() {
        return ResultMap.getResultMap(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDescription(), iShareService.getTagList());
    }

    /**
     * 更新标签内容
     *
     * @param tagForm 更新标签内容
     * @return 更新结果
     */
    @PutMapping(value = "/tag/update")
    public ResultMap updateTag(@RequestBody ShareTagForm tagForm) {
        boolean result = iShareService.updateTag(tagForm);
        return result ? ResultMap.getResultMap(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDescription(), result)
                : ResultMap.getResultMap(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDescription(),result);
    }

    /**
     * 添加标签
     *
     * @param tagForm 添加的标签内容
     * @return 添加结果
     */
    @PostMapping(value = "/tag/insert")
    public ResultMap insertTag(@RequestBody ShareTagForm tagForm) {
        boolean result = iShareService.insertTag(tagForm);
        // TODO 请求成功的响应码与查询结果异常的状态码的区分问题如何解决
        return result ? ResultMap.getResultMap(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDescription(), result)
                : ResultMap.getResultMap(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDescription(),result);
    }

    /**
     * 根据标签ID查询标签
     *
     * @param id 标签ID
     * @return 查询结果
     */
    @GetMapping(value = "/tag/{id}")
    public ResultMap selectTagById(@PathVariable("id") Integer id) {
        ShareTag tag = iShareService.selectTagById(id);
        return ResultMap.getResultMap(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDescription(), tag);
    }

}
