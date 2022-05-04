package com.agoni.dgy.service;

import com.agoni.dgy.model.bo.CourseSearchFrom;
import com.agoni.dgy.model.po.Course;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程表 服务类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
public interface CourseService extends IService<Course> {
    
    /**
     * 条件分页查询
     * @param from
     *
     * @return
     */
    IPage<Course> searchPage(CourseSearchFrom from);
    
    /**
     * 根据名字返回list
     * @param courseName
     *
     * @return
     */
    List<Course> listByCourseName(String courseName);
}
