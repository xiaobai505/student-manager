package com.agoni.dgy.dao;

import com.agoni.dgy.model.TbClass;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbClassDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TbClass record);

    int insertSelective(TbClass record);

    TbClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbClass record);

    int updateByPrimaryKey(TbClass record);
}