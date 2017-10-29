package com.snail.controller.backend;

import com.snail.commen.ResultMap;
import com.snail.interceptor.ParameterThreadLocal;
import com.snail.pojo.form.ShareForm;
import com.snail.service.base.IShareService;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    public ResultMap addShare(@RequestBody ShareForm shareForm, HttpSession session) {
        return ResultMap.getResultMap(200, "添加成功", iShareService.insertShare(shareForm, session));
    }
}
