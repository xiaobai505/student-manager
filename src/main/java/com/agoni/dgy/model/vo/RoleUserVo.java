package com.agoni.dgy.model.vo;

import com.agoni.dgy.model.po.RoleUser;
import com.baomidou.mybatisplus.annotation.TableField;
import com.diboot.core.binding.annotation.BindDict;
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
    
    @ApiModelProperty("状态")
    @TableField("state")
    @BindDict(type="String", field = "status")
    private String stateLabel;
    
    @ApiModelProperty("角色编码")
    private String roleCode;
    
    @ApiModelProperty("角色类型")
    private String roleType;

}
