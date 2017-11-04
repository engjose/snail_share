package com.snail.service.base;

import com.snail.pojo.domain.Employee;
import com.snail.pojo.form.EmployeeInsertForm;
import com.snail.pojo.form.EmployeeQueryForm;
import java.util.Map;

/**
 *  @description 用户管理模块业务层接口
 *  Create By Jiankun.Zhangsun 2017年10月14日15:57:57
 */
public interface IUserManagerService {

    /**
     * 查询用户列表
     *
     * @return 用户列表
     */
    Map<String, Object> listEmployees(EmployeeQueryForm form);

    /**
     * 根据用户的ID查询用户详情
     *
     * @param id 用户ID
     * @return 用户详情对象
     */
    Employee getEmployeeById(Integer id);

    /**
     * 添加用户
     *
     * @param form 用户信息
     */
    void insertEmployee(EmployeeInsertForm form);
}
