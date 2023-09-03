package com.agoni.dgy.service;

import com.agoni.dgy.model.bo.CourseSearchFrom;
import com.agoni.dgy.model.po.Course;
import com.agoni.dgy.model.vo.CourseVo;
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
    IPage<CourseVo> selectPage(CourseSearchFrom from);
    
    /**
     * 根据名字返回list
     * @param courseName
     *
     * @return
     */
    List<Course> listByCourseName(String courseName);
    
    /**
     * 校验库存
     * @param id
     */
    Course checkStock(Long id);
    
    /**
     * 扣减库存
     * @param course
     */
    boolean saleStock(Course course);
    
    /**
     * 还原库存
     * @param id
     *
     */
    boolean delStock(Long id);
}
