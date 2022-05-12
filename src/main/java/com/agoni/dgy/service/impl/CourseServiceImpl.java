package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.CourseMapper;
import com.agoni.dgy.model.bo.CourseSearchFrom;
import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.model.vo.AuthUserVo;
import com.agoni.dgy.service.CourseService;
import com.agoni.security.utils.UserUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Service
@Slf4j
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    
    private static final SimpleGrantedAuthority admin = new SimpleGrantedAuthority("admin");
    
    @Override
    public IPage<Course> searchPage(CourseSearchFrom from) {
        return page(from, checkValid(from));
    }
    
    private QueryWrapper<Course> checkValid(CourseSearchFrom from) {
        AuthUserVo userVo = UserUtil.getUser();
        QueryWrapper<Course> query = new QueryWrapper<>();
        query.lambda()
                .likeRight(StringUtils.isNotEmpty(from.getCourseName()), Course::getCourseName, from.getCourseName())
                .likeRight(StringUtils.isNotEmpty(from.getTeacher()), Course::getCourseTeacher, from.getTeacher())
                //.eq(!userVo.getAuthorities().contains(admin),Course::getIsMust,false)
                .eq(ObjectUtils.isNotNull(from.getIsMust()),Course::getIsMust,from.getIsMust());
        return query;
    }
    
    @Override
    public List<Course> listByCourseName(String courseName) {
        QueryWrapper<Course> query = new QueryWrapper<>();
        query.lambda().likeRight(StringUtils.isNotEmpty(courseName), Course::getCourseName, courseName);
        return list(query);
    }
    
    @Override
    public Course checkStock(Long id) {
        Course course = this.getById(id);
        if (course.getSale().equals(course.getStock())) {
            throw new RuntimeException("库存不足");
        }
        return course;
    }
    
    @Override
    public boolean saleStock(Course course) {
        course.setSale(course.getSale() + 1);
        return updateById(course);
    }
    
    @Override
    public boolean delStock(Long id) {
        Course course = this.getById(id);
        course.setSale(course.getSale() - 1);
        return updateById(course);
    }
}
