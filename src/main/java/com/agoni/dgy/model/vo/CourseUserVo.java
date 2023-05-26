package com.agoni.dgy.model.vo;

import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.model.po.CourseUser;
import com.agoni.system.model.po.User;
import com.diboot.core.binding.annotation.BindField;
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
@ApiModel(value = "CourseUserVo对象", description = "用户课程关系表")
public class CourseUserVo extends CourseUser {

    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty("课程名称")
    @BindField(entity= Course.class, field="courseName", condition="this.course_id=id")
    private String courseName;

    @ApiModelProperty("课程老师")
    @BindField(entity= Course.class, field="courseTeacher", condition="this.course_id=id")
    private String courseTeacher;
    
    @ApiModelProperty("获得的学分")
    @BindField(entity= Course.class, field="graduate", condition="this.course_id=id")
    private int graduate;
    
    @ApiModelProperty("真实姓名")
    @BindField(entity= User.class, field="name", condition="this.user_id=id")
    private String name;
    
    @ApiModelProperty("用户名")
    @BindField(entity= User.class, field="username", condition="this.user_id=id")
    private String username;
    
}
