package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * <p>
 * 用户课程关系表
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_course_user")
@ApiModel(value = "CourseUser对象", description = "用户课程关系表")
public class CourseUser extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty("用户ID")
    @TableField("user_id")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long userId;

    @ApiModelProperty("课程ID")
    @TableField("course_id")
    @JsonSerialize(using= ToStringSerializer.class)
    private Long courseId;

    @ApiModelProperty("最高分数")
    @TableField("best_score")
    private String bestScore;

}
