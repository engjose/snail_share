package com.snail.pojo.form;

/**
 * 员工查询Form
 *
 * Created by Panyuanyuan on 2017/10/13.
 */
public class EmployeeQueryForm {

    /** 手机号 */
    private String mobile;

    /** 登录名 */
    private String loginName;

    /** 真实姓名 */
    private String name;

    /** 分页pageNo */
    private Integer pageNo = 1;

    /** 分页pageSize */
    private Integer pageSize = 10;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
