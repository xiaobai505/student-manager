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
import lombok.*;

/**
 * <p>
 * 成绩表
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_result")
@ApiModel(value = "Result对象", description = "成绩表")
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("班级名称")
    @TableField("class_name")
    private String className;

    @ApiModelProperty("班级code")
    @TableField("class_code")
    private String classCode;

    @ApiModelProperty("成绩")
    @TableField("result")
    private String result;

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
