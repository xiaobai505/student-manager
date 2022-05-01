package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.CourseMapper;
import com.agoni.dgy.model.bo.CourseSearchFrom;
import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.model.po.Major;
import com.agoni.dgy.service.CourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    
    @Override
    public IPage<Major> majorPage(CourseSearchFrom from) {
        QueryWrapper<Course> query = new QueryWrapper<>();
        query.lambda()
                .likeRight(StringUtils.isNotEmpty(from.getCourseName()), Course::getCourseName, from.getCourseName())
                .likeRight(StringUtils.isNotEmpty(from.getTeacher()), Course::getCourseTeacher, from.getTeacher());
        return page(from, query);
    }
}
