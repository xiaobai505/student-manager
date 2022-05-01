package com.agoni.dgy.service;

import com.agoni.dgy.model.bo.CourseSearchFrom;
import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.model.po.Major;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程表 服务类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
public interface CourseService extends IService<Course> {
    
    IPage<Major> majorPage(CourseSearchFrom from);
}
