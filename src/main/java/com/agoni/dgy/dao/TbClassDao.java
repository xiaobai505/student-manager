package com.agoni.dgy.dao;

import com.agoni.dgy.model.TbClass;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

public interface TbClassDao extends BaseMapper<TbClass>{
    int deleteByPrimaryKey(Integer id);

    int insert(TbClass record);

    int insertSelective(TbClass record);

    TbClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbClass record);

    int updateByPrimaryKey(TbClass record);

    List<TbClass> selectAll();
}