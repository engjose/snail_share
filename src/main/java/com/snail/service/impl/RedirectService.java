package com.snail.service.impl;

import com.snail.commen.ResultMap;
import org.springframework.stereotype.Service;

/**
 * @Author: Panyuanyuan
 * @Date: Created in 下午3:02 2017/10/27
 * @Description:
 */
@Service
public class RedirectService {
    public ResultMap redirectLogin() {
        return ResultMap.getResultMap(403, "请确认是否登录");
    }
}
