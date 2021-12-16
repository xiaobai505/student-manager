package com.agoni.dgy.service;

import com.agoni.dgy.model.TbClass;
import com.agoni.dgy.model.TbCourse;
import org.springframework.stereotype.Service;


public interface TbCourseService {

    /**
     * 根据id查询课程信息
     * @param id
     * @return TbCourse
     */
    TbClass selectByPrimaryKey(Integer id);
}
