package com.agoni.dgy.model;

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
@TableName("tb_course_user")
@ApiModel(value = "CourseUser对象", description = "用户课程关系表")
public class CourseUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户角色关系")
    @TableId("id")
    private Long id;

    @ApiModelProperty("用户ID")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty("课程ID")
    @TableField("course_id")
    private Long courseId;

    @ApiModelProperty("最高分数")
    @TableField("best_score")
    private String bestScore;

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
