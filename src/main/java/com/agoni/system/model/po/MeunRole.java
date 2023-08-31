package com.agoni.system.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 菜单角色关联表
 * @TableName sys_meun_role
 */
@TableName(value ="sys_menu_role")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MeunRole implements Serializable {
    
    @ApiModelProperty("角色id")
    private Long roleId;

    @ApiModelProperty("菜单id")
    private Long meunId;

}