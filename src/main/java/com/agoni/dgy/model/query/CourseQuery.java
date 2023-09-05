package com.agoni.dgy.model.query;

import com.agoni.system.model.query.BasePageQuery;
import lombok.Data;

import java.util.List;

/**
 * @author gyd
 */
@Data
public class CourseQuery extends BasePageQuery {

    /**
     * 课程名称
     */
    private String courseNameLike;

    /**
     * 授课教师
     */
    private String teacherLike;

    /**
     * 是否必修
     */
    private Boolean isMustEq;

    /**
     * 部门
     */
    private Long deptId;

    /**
     * 下级部门id
     */
    List<Long> deptIds;
}
