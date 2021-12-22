package com.agoni.dgy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Getter
@Setter
@TableName("tb_role")
@ApiModel(value = "Role对象", description = "角色表")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("角色名称")
    @TableField("role_name")
    private String roleName;

    @ApiModelProperty("角色编码")
    @TableField("role_code")
    private String roleCode;

    @ApiModelProperty("角色类型")
    @TableField("role_type")
    private String roleType;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("创建人标识")
    @TableField("create_by")
    private String createBy;

    @ApiModelProperty("创建人姓名")
    @TableField("create_by_name")
    private String createByName;

    @ApiModelProperty("最后修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("最后修改人标识")
    @TableField("update_by")
    private String updateBy;

    @ApiModelProperty("最后修改人姓名")
    @TableField("update_by_name")
    private String updateByName;

    @ApiModelProperty("删除标记（0：正常，1：删除）")
    @TableField("del_flag")
    @TableLogic
    private Integer delFlag;


}
