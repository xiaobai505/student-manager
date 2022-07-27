package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.diboot.core.binding.annotation.BindDict;
import com.diboot.core.binding.annotation.BindEntity;
import com.diboot.core.binding.annotation.BindEntityList;
import com.diboot.core.binding.query.BindQuery;
import com.diboot.core.binding.query.Comparison;
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
@TableName("tb_role_user")
@ApiModel(value = "RoleUser对象", description = "用户角色关系表")
public class RoleUser extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户角色关系")
    @TableId("id")
    private Long id;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    @BindDict(type="USER_STATUS", field = "status")
    private Long userId;
    
    @ApiModelProperty("角色ID")
    @TableField("role_id")
    private Long roleId;

    @ApiModelProperty("角色名称")
    @TableField("role_name")
    private String roleName;

    @ApiModelProperty("状态")
    @TableField("state")
    private String state;

}
