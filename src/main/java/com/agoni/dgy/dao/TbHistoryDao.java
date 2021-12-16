package com.agoni.dgy.dao;

import com.agoni.dgy.model.TbHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbHistoryDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TbHistory record);

    int insertSelective(TbHistory record);

    TbHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbHistory record);

    int updateByPrimaryKey(TbHistory record);
}