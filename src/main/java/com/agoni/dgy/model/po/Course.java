package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 课程表
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_course")
@ApiModel(value = "Course对象", description = "课程表")
public class Course extends AbstractEntity implements Serializable {

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

    @ApiModelProperty("上课时间")
    @TableField("time_table")
    private LocalDateTime timeTable;

    @ApiModelProperty("库存")
    @TableField("stock")
    private Integer stock;

    @ApiModelProperty("是否必修")
    @TableField("is_must")
    private Boolean isMust;

    @ApiModelProperty("版本号")
    @TableField("vetsion")
    private Integer vetsion;

}
