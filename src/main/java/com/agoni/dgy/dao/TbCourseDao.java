package com.agoni.dgy.dao;

import com.agoni.dgy.model.TbCourse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbCourseDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCourse record);

    int insertSelective(TbCourse record);

    TbCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbCourse record);

    int updateByPrimaryKey(TbCourse record);
}