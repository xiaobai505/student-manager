package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
public class Result extends AbstractEntity  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("课程id")
    @TableField("course_id")
    private String courseId;

    @ApiModelProperty("学生姓名")
    @TableField("student_name")
    private String studentName;

    @ApiModelProperty("成绩")
    @TableField("result")
    private String result;

}
