package com.agoni.system.model.vo;

import com.agoni.system.model.po.Role;
import com.agoni.system.model.po.RoleUser;
import com.diboot.core.binding.annotation.BindField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

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
    
    @ApiModelProperty("角色List")
    @BindField(entity= Role.class, field="roleName", condition="this.role_id=id")
    private List<String> roleList;
    
    @ApiModelProperty("角色名称")
    private String roleName;
    
    @ApiModelProperty("角色编码")
    @BindField(entity= Role.class, field="roleCode", condition="this.role_id=id")
    private String roleCode;
    
}
