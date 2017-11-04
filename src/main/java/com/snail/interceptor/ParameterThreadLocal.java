package com.snail.interceptor;

/**
 * @Author: Panyuanyuan
 * @Date: Created in 下午9:33 2017/10/29
 * @Description:
 */
@SuppressWarnings("unchecked")
public class ParameterThreadLocal {
    private static ThreadLocal<Integer> uid = new ThreadLocal();
    private static ThreadLocal<String> loginName = new ThreadLocal();
    private static ThreadLocal<String> token = new ThreadLocal();
    private static ThreadLocal<String> app = new ThreadLocal<>();

    public ParameterThreadLocal() {
    }

    public static ThreadLocal<String> getApp() {
        return app;
    }

    public static void setApp(ThreadLocal<String> app) {
        ParameterThreadLocal.app = app;
    }

    public static ThreadLocal<Integer> getUid() {
        return uid;
    }

    public static void setUid(ThreadLocal<Integer> uid) {
        ParameterThreadLocal.uid = uid;
    }

    public static ThreadLocal<String> getLoginName() {
        return loginName;
    }

    public static void setLoginName(ThreadLocal<String> loginName) {
        ParameterThreadLocal.loginName = loginName;
    }

    public static ThreadLocal<String> getToken() {
        return token;
    }

    public static void setToken(ThreadLocal<String> token) {
        ParameterThreadLocal.token = token;
    }
}
