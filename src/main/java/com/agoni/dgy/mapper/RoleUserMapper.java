package com.agoni.dgy.mapper;

import com.agoni.dgy.model.po.RoleUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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

}
