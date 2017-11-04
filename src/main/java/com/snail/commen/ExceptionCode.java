package com.snail.commen;

/**
 *  @description 异常状态码维护
 *
 *  @author Jiankun.Zhangsun 2017年11月4日22:15:18
 */
public enum ExceptionCode {

    /** 请求参数不能为空异常 */
    REQUEST_ARGUMENT_NOT_BE_NULL(400, "NULL_ARGUMENT");

    private final Integer code;
    private final String description;

    ExceptionCode(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode () {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
