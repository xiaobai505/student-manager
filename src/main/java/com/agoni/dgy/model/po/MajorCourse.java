package com.agoni.dgy.model.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 专业课程关联表
 * @TableName tb_major_course
 */
@TableName(value ="tb_major_course")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "MajorCourse", description = "专业课程关联表")
public class MajorCourse implements Serializable {
    /**
     * ID
     */
    @TableId
    @ApiModelProperty("id")
    private Long id;
    
    
    @ApiModelProperty("部门ID")
    private Long majorId;

    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private Long courseId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}