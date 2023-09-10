package com.agoni.dgy.model.po;

import com.agoni.system.model.po.AbstractEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@TableName("tb_course")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "DictConfig对象", description = "字典配置表")
public class Course extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty("课程名称")
    @TableField("course_name")
    private String courseName;

    @ApiModelProperty("部门ID")
    @TableField("dept_id")
    private String deptId;

    @ApiModelProperty("课程老师")
    @TableField("course_teacher")
    private String courseTeacher;

    @ApiModelProperty("开始时间")
    @TableField("start_time")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime startTime;

    @ApiModelProperty("结束时间")
    @TableField("end_time")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime endTime;

    @ApiModelProperty("上课时间")
    @TableField("time_table")
    private String timeTable;

    @ApiModelProperty("库存")
    @TableField("stock")
    private Integer stock;
    
    @ApiModelProperty("占座数量")
    @TableField("sale")
    private Integer sale;

    @ApiModelProperty("是否必修")
    @TableField("is_must")
    private Integer isMust;
    
    @ApiModelProperty("获得的学分")
    @TableField("graduate")
    private int graduate;

    @ApiModelProperty("版本号")
    @TableField("vetsion")
    @Version
    private Integer vetsion;

}
