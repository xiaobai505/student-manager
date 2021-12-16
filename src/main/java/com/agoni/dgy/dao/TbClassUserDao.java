package com.agoni.dgy.dao;

import com.agoni.dgy.model.TbClassUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbClassUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TbClassUser record);

    int insertSelective(TbClassUser record);

    TbClassUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbClassUser record);

    int updateByPrimaryKey(TbClassUser record);
}