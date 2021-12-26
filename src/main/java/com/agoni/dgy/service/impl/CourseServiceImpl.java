package com.agoni.dgy.service.impl;

import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.mapper.CourseMapper;
import com.agoni.dgy.service.CourseService;
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

}
