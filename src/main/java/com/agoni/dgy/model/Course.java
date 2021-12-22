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
 * 课程表
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Getter
@Setter
@TableName("tb_course")
@ApiModel(value = "Course对象", description = "课程表")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("课程名称")
    @TableField("course_name")
    private String courseName;

    @ApiModelProperty("课程老师")
    @TableField("course_teacher")
    private String courseTeacher;

    @ApiModelProperty("开始时间")
    @TableField("start_time")
    private LocalDateTime startTime;

    @ApiModelProperty("结束时间")
    @TableField("end_time")
    private LocalDateTime endTime;

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
