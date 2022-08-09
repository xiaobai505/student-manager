package com.agoni.dgy.model.po;

import com.agoni.system.Interceptor.Fastjson2TypeHandler;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 菜单表
 * @TableName tb_menutree
 */
@TableName(value ="tb_menu",autoResultMap=true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Menu extends AbstractEntity {

    /**
     * 父id
     */
    @ApiModelProperty("父id")
    @TableField("parentId")
    private Long parentId;

    /**
     * 类型 /systemRouter/permissionRouter/frameRouter/tabsRouter/
     */
    @TableField("menu_type")
    private String menuType;
    
    /**
     * 路径
     */
    @TableField("path")
    private String path;

    /**
     * 重定向
     */
    @TableField("redirect")
    private String redirect;
    
    /**
     * 页面name，作为一种规范
     */
    @TableField("name")
    private String name;

    /**
     * 排序/名字/图表/是否缓存
     */
    @TableField(value = "meta",typeHandler = Fastjson2TypeHandler.class)
    private JSONObject meta;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;
}