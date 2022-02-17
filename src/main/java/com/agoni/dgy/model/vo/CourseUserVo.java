package com.agoni.dgy.model.vo;

import com.agoni.dgy.model.po.AbstractEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 用户课程关系表
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "CourseUser对象", description = "用户课程关系表")
public class CourseUserVo extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户角色关系")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    @ApiModelProperty("用户ID")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long userId;

    @ApiModelProperty("课程ID")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long courseId;

    @ApiModelProperty("最高分数")
    private String bestScore;

    @ApiModelProperty("课程名称")
    private String courseName;

    @ApiModelProperty("课程老师")
    private String courseTeacher;

}
