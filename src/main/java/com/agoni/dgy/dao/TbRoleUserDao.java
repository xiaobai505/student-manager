package com.agoni.dgy.dao;

import com.agoni.dgy.model.TbRoleUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbRoleUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TbRoleUser record);

    int insertSelective(TbRoleUser record);

    TbRoleUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TbRoleUser record);

    int updateByPrimaryKey(TbRoleUser record);
}