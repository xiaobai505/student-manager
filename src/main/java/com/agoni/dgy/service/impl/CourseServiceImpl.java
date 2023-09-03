package com.agoni.dgy.service.impl;

import com.agoni.core.diboot.Binder;
import com.agoni.core.exception.BusinessException;
import com.agoni.core.omp.OmpDbUtil;
import com.agoni.dgy.mapper.CourseMapper;
import com.agoni.dgy.model.bo.CourseSearchFrom;
import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.model.vo.CourseVo;
import com.agoni.dgy.service.CourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.agoni.core.exception.enums.BusinessBaseEnum.STOCK_NULL;

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

    @Override
    public IPage<CourseVo> selectPage(CourseSearchFrom from) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        fillQueryWrapper(queryWrapper, from);
        Page<Course> page = Page.of(from.getCurrentPage(), from.getPageSize());
        Page<Course> records = page(page, queryWrapper);
        return Binder.convertAndBindRelations(records, CourseVo.class);
    }


    private void fillQueryWrapper(QueryWrapper<Course> queryWrapper,CourseSearchFrom from) {
        //自动组装查询条件，生成orderBy，组装条件的两种方式：1.基于注解 2.基于query对象中属性的后缀
        OmpDbUtil.autoWrapper(from, queryWrapper, Course.class);
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
            throw new BusinessException(STOCK_NULL);
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
