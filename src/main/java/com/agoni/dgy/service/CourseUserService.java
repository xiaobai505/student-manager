package com.agoni.dgy.service;

import com.agoni.dgy.model.po.CourseUser;
import com.agoni.dgy.model.query.CourseUserQuery;
import com.agoni.dgy.model.vo.CourseUserVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户课程关系表 服务类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
public interface CourseUserService extends IService<CourseUser> {

    List<CourseUserVo>  mylist();
    
    /**
     * 查询 用户课程关系表 信息
     * @param from
     *
     * @return
     */
    IPage<CourseUserVo> searchPage(CourseUserQuery from);
    
    /**
     * 创建 用户课程关系表
     * @param id
     *
     * @return
     */
    boolean saveCourse(Long id);
    
    /**
     * 放弃 用户选课信息
     * @param courseUser
     *
     * @return
     */
    boolean deleteById(CourseUser courseUser);

    /**
     * 放弃 用户选课信息
     * @param id
     *
     * @return
     */
    boolean deleteByCourseId(Long id);
}
