package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 菜单角色关联表
 * @TableName tb_meun_role
 */
@TableName(value ="tb_meun_role")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MeunRole extends AbstractEntity {
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 菜单id
     */
    private Long meunId;

}