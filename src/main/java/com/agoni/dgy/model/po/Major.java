package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 班级表
 * </p>
 *
 * @author dgy
 * @since 2022-01-04
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_major")
@ApiModel(value = "Major对象", description = "班级表")
public class Major implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("学校分院")
    @TableField("School")
    private String school;

    @ApiModelProperty("专业")
    @TableField("major")
    private String major;

    @ApiModelProperty("班级名称")
    @TableField("class_name")
    private String className;

    @ApiModelProperty("班级code")
    @TableField("class_code")
    private String classCode;

    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("创建人标识")
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    @ApiModelProperty("创建人姓名")
    @TableField(value = "create_by_name", fill = FieldFill.INSERT)
    private String createByName;

    @ApiModelProperty("最后修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("最后修改人标识")
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private String updateBy;

    @ApiModelProperty("最后修改人姓名")
    @TableField(value = "update_by_name", fill = FieldFill.UPDATE)
    private String updateByName;

    @ApiModelProperty("删除标记（0：正常，1：删除）")
    @TableField("del_flag")
    @TableLogic
    private Integer delFlag;


}
