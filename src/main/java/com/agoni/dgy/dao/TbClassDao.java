package com.agoni.dgy.dao;

import com.agoni.dgy.model.TbClass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbClassDao{
    int deleteByPrimaryKey(Integer id);

    int insert(TbClass record);

    int insertSelective(TbClass record);

    TbClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbClass record);

    int updateByPrimaryKey(TbClass record);

    List<TbClass> selectAll();
}