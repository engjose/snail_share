package com.snail.interceptor;

import com.snail.util.JedisClientUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import redis.clients.jedis.Jedis;

/**
 * @Author: Panyuanyuan
 * @Date: Created in 下午5:47 2017/10/25
 * @Description:
 */
public class SsoInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String xToken = request.getHeader("xToken");
        Jedis jedis = JedisClientUtil.getJedis();

        String userLogin = null;
        if (StringUtils.isNotBlank(xToken)) {
             userLogin = jedis.get(xToken);
            JedisClientUtil.closeJedis(jedis);
        }

        if (StringUtils.isBlank(userLogin)) {
            response.sendError(403, "没有权限");
            return false;
        }
        return true;
    }
}
