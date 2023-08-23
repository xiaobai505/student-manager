package com.agoni.system.model.query;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserQuery extends PageBaseQuery {
    
    /**
     * 用户名
     */
    private String username;
    
    /**
     * 手机号
     */
    private String phone;
    
    /**
     * 状态
     */
    private Integer status;

    /**
     * 部门
     */
    @NotNull(message = "接口错误，部门id不能为空！")
    private Long deptId;
    
}
