package com.agoni.dgy.model.vo;

import com.agoni.dgy.model.po.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 关联用户表信息，不显示密码，所以不继承USER表了
 *
 * @author dgy
 * @since 2021-12-22
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "UserAndRole对象", description = "用户表")
public class UserAndRole extends User {

    @ApiModelProperty("角色ids")
    private String roleIds;

    @ApiModelProperty("角色名称")
    private String roles;
    
}
