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
        String xToken = request.getParameter("xToken");
        Jedis jedis = JedisClientUtil.getJedis();
        String loginName = null;
        if (StringUtils.isNotBlank(xToken)) {
            loginName = jedis.get(xToken);
            JedisClientUtil.closeJedis(jedis);
        }

        if (StringUtils.isBlank(loginName)) {
            response.sendError(403, "没有权限");
            return false;
        }

        setUserParams(xToken, "aa");
        return true;
    }

    /**
     * 设置用户信息与线程参数
     *
     * @param xToken
     */
    private void setUserParams(String xToken, String loginName) {
        ParameterThreadLocal.getToken().set(xToken);
        ParameterThreadLocal.getLoginName().set(loginName);
    }
}
