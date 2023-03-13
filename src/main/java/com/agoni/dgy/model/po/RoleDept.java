package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 角色和部门关联表
 * @TableName sys_role_dept
 */
@TableName(value ="sys_role_dept")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "RoleDept对象", description = "角色和部门关联表")
public class RoleDept implements Serializable {
    
    @ApiModelProperty("用户角色关系")
    @TableId("id")
    private Long id;
    
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 部门ID
     */
    private Long deptId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    
}