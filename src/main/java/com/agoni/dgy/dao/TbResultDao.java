package com.agoni.dgy.dao;

import com.agoni.dgy.model.TbResult;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbResultDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TbResult record);

    int insertSelective(TbResult record);

    TbResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbResult record);

    int updateByPrimaryKey(TbResult record);
}