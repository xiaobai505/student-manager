package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 菜单角色关联表
 * @TableName tb_meun_role
 */
@TableName(value ="tb_meun_role")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MeunRole implements Serializable {
    
    @ApiModelProperty("用户角色关系")
    @TableId("id")
    private Long id;
    
    @ApiModelProperty("角色id")
    private Long roleId;

    /**
     * 菜单id
     */
    @ApiModelProperty("菜单id")
    private Long meunId;

}