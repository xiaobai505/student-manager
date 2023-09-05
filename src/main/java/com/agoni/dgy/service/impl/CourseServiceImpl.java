package com.agoni.dgy.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.agoni.core.diboot.Binder;
import com.agoni.core.exception.BusinessException;
import com.agoni.core.omp.OmpDbUtil;
import com.agoni.dgy.mapper.CourseMapper;
import com.agoni.dgy.model.bo.CourseSearchFrom;
import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.model.po.Result;
import com.agoni.dgy.model.vo.CourseVo;
import com.agoni.dgy.service.CourseService;
import com.agoni.dgy.service.ResultService;
import com.agoni.system.utils.UserUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
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
    private ResultService resultService;

    @Override
    public IPage<CourseVo> selectPage(CourseSearchFrom from) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        fillQueryWrapper(queryWrapper, from);
        Page<Course> page = Page.of(from.getCurrentPage(), from.getPageSize());
        Page<Course> records = page(page, queryWrapper);
        return Binder.convertAndBindRelations(records, CourseVo.class);
    }

    public Page<CourseVo> init(Page<Course> records){
        Page<CourseVo> voPage = Binder.convertAndBindRelations(records, CourseVo.class);
        List<CourseVo> list = voPage.getRecords();
        if (CollUtil.isNotEmpty(voPage.getRecords())){
            Map<Long, List<Result>> map = getResultMap(list);
            for (CourseVo courseVo : list) {
                List<Result> results = map.get(courseVo.getId());
                if (CollUtil.isNotEmpty(results)) {
                    courseVo.setCount(results.size());
                }
            }
            voPage.setRecords(list);
        }
        return voPage;
    }

    /**
     * 获取当前用户下，所有的记录
     * @param list
     * @return
     */
    private Map<Long, List<Result>> getResultMap(List<CourseVo> list) {
        List<Long> ids = list.stream().map(CourseVo::getId).collect(Collectors.toList());
        List<Result> resultList = resultService.lambdaQuery()
                .eq(Result::getUserId, UserUtil.getUser().getId())
                .in(CollUtil.isNotEmpty(ids),Result::getCourseId, ids)
                .list();
        return resultList.stream().collect(Collectors.groupingBy(Result::getCourseId));
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
