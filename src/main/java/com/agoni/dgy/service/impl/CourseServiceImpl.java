package com.agoni.dgy.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.agoni.core.diboot.Binder;
import com.agoni.core.exception.BusinessException;
import com.agoni.core.omp.OmpDbUtil;
import com.agoni.dgy.mapper.CourseMapper;
import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.model.query.CourseQuery;
import com.agoni.dgy.model.vo.CourseVo;
import com.agoni.dgy.service.CourseService;
import com.agoni.system.service.DeptService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Resource
    private DeptService deptService;

    @Override
    public IPage<CourseVo> selectPage(CourseQuery query) {
        setDeptIds(query);
        Page<Course> page = Page.of(query.getCurrentPage(), query.getPageSize());
        LambdaQueryWrapper<Course> lambdaQueryWrapper = getLambdaQueryWrapper(query);
        Page<Course> records = page(page, lambdaQueryWrapper);
        return Binder.convertAndBindRelations(records, CourseVo.class);
    }

    /**
     * 获取所有父部门的id
     * @param query
     */
    private void setDeptIds(CourseQuery query) {
        if (ObjectUtil.isNotEmpty(query.getDeptId())) {
            String[] split = deptService.getById(query.getDeptId()).getAncestors().split(StrUtil.COMMA);
            List<Long> ids = Arrays.stream(split).map(Long::parseLong).collect(Collectors.toList());
            ids.add(query.getDeptId());
            query.setDeptIds(ids);
        }
    }

    private void fillQueryWrapper(QueryWrapper<Course> queryWrapper, CourseQuery from) {
        //自动组装查询条件，生成orderBy，组装条件的两种方式：1.基于注解 2.基于query对象中属性的后缀
        OmpDbUtil.autoWrapper(from, queryWrapper, Course.class);
    }

    /**
     * 特殊的查询 拼装or
     * @param cq 查询条件
     * @return
     */
    private LambdaQueryWrapper<Course> getLambdaQueryWrapper(CourseQuery cq) {
        LambdaQueryWrapper<Course> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ObjectUtil.isNotEmpty(cq.getIsMustEq()), Course::getIsMust, cq.getIsMustEq())
                .like(StrUtil.isNotEmpty(cq.getCourseNameLike()), Course::getCourseName, cq.getCourseNameLike())
                .eq(StrUtil.isNotEmpty(cq.getTeacherLike()), Course::getCourseTeacher, cq.getTeacherLike())
                .in(ObjectUtil.isNotEmpty(cq.getDeptId()),Course::getDeptId, cq.getDeptIds());
        return queryWrapper;
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
