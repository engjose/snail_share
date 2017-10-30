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
        Integer userId = null;
        if (StringUtils.isNotBlank(xToken)) {
            String loginNameAndUserId = jedis.get(xToken);
            String[] strArr = loginNameAndUserId.split(":");
            if(strArr.length > 0) {
                loginName = strArr[0];
                userId = Integer.valueOf(strArr[1]);
            }
            JedisClientUtil.closeJedis(jedis);
        }

        if (StringUtils.isBlank(loginName) && userId != null) {
            response.sendError(403, "没有权限");
            return false;
        }

        setUserParams(xToken, loginName, userId);
        return true;
    }

    /**
     * 设置用户信息与线程参数
     *
     * @param xToken
     * @param loginName
     * @param userId
     */
    private void setUserParams(String xToken, String loginName, Integer userId) {
        ParameterThreadLocal.getToken().set(xToken);
        ParameterThreadLocal.getUid().set(userId);
        ParameterThreadLocal.getLoginName().set(loginName);
    }
}
