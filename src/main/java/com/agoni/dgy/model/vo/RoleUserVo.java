package com.agoni.dgy.model.vo;

import com.agoni.dgy.model.po.Role;
import com.agoni.dgy.model.po.RoleUser;
import com.agoni.dgy.model.po.User;
import com.baomidou.mybatisplus.annotation.TableField;
import com.diboot.core.binding.annotation.BindDict;
import com.diboot.core.binding.annotation.BindEntity;
import com.diboot.core.binding.annotation.BindField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * <p>
 * 用户角色关系表
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "RoleUser对象", description = "用户角色关系表")
public class RoleUserVo extends RoleUser {
    
    @BindEntity(entity = User.class, condition="this.user_id=id")
    private User user;
    
    @ApiModelProperty("角色ID")
    @TableField("role_id")
    private Long roleId;
    
    @BindField(entity= Role.class, field="roleName", condition="this.role_id=id")
    private String roles;
    
    @ApiModelProperty("角色编码")
    private String roleCode;
    
    @ApiModelProperty("角色类型")
    private String roleType;
    
    @BindDict(type="USER_STATUS", field = "state")
    private String statusLabel;
}
