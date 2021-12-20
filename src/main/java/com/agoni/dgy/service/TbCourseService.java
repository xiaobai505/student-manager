package com.agoni.dgy.service;

import com.agoni.dgy.model.TbClass;
import com.agoni.dgy.model.TbCourse;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TbCourseService {

    /**
     * 根据id查询课程信息
     * @param id
     * @return TbCourse
     */
    TbClass selectByPrimaryKey(Integer id);

    /**
     * 查询所有
     * @return
     */
    PageInfo<TbClass> selectAll();

    /**
     * 查询所有
     * @return
     */
    PageInfo<TbClass> selectAll2();

}
