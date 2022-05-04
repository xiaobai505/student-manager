package com.agoni.dgy.service;

import com.agoni.dgy.model.bo.CourseUserSearchFrom;
import com.agoni.dgy.model.po.CourseUser;
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
    
    IPage<CourseUser> searchPage(CourseUserSearchFrom from);
    
    
}
