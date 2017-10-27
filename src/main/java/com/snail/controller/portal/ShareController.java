package com.snail.controller.portal;

import com.snail.commen.ResponseCode;
import com.snail.commen.ResultMap;
import com.snail.service.base.IShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户分享Controller
 *
 * Created by panyuanyuan on 2017/10/15.
 */
@RestController
@RequestMapping("/share")
@CrossOrigin
public class ShareController {

    @Autowired
    private IShareService iShareService;

    /**
     * 获取用户分享列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public ResultMap getShareList(@RequestParam(defaultValue = "1") Integer pageNo,
        @RequestParam(defaultValue = "10") Integer pageSize) {
        return ResultMap.getResultMap(ResponseCode.SUCCESS.getCode(), iShareService.listShares(pageNo, pageSize));
    }
}
