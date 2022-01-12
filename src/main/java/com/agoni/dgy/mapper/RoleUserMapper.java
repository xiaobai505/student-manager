package com.agoni.dgy.mapper;

import com.agoni.dgy.model.po.RoleUser;
import com.agoni.dgy.model.vo.RoleUserVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户角色关系表 Mapper 接口
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Mapper
public interface RoleUserMapper extends BaseMapper<RoleUser> {

    List<RoleUserVo> selectUserAndRole(@Param("id") Long id);
}
