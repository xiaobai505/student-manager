package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * <p>
 * 成绩表
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_result")
@ApiModel(value = "Result对象", description = "成绩表", parent = AbstractEntity.class)
public class Result extends AbstractEntity<AbstractEntity> {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("课程id")
    @TableField("course_id")
    private Long courseId;
    
    @ApiModelProperty("课程名")
    @TableField("course_name")
    private String courseName;
    
    @ApiModelProperty("成绩")
    @TableField("result")
    private String result;
    
    @ApiModelProperty("补考标记")
    private Integer isReset;
    
    @ApiModelProperty("获得的学分")
    private int graduate;

}
