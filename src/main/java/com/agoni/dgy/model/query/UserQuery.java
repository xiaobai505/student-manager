package com.agoni.dgy.model.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class UserQuery extends Page {
    
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
     * 角色
     */
    private String roles;
    
    /**
     * 部门
     */
    @NotNull(message = "接口错误，部门id不能为空！")
    private Long deptId;
    
}
