package com.agoni.dgy.dao;

import com.agoni.dgy.model.TbCourseUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbCourseUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TbCourseUser record);

    int insertSelective(TbCourseUser record);

    TbCourseUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbCourseUser record);

    int updateByPrimaryKey(TbCourseUser record);
}