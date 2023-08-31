package com.agoni.system.model.query;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UserQuery extends PageBaseQuery {
    
    /**
     * 用户名
     */
    private String usernameEq;
    
    /**
     * 手机号
     */
    private String phoneEq;
    
    /**
     * 状态
     */
    private Integer statusEq;

    /**
     * 部门
     */
    @NotNull(message = "接口错误，部门id不能为空！")
    private Long deptId;

    /**
     * 下级部门
     */
    List<Long> deptIds;
    
}
