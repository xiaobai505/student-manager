package com.agoni.dgy.mapper;


import com.agoni.dgy.model.po.User;
import com.agoni.dgy.model.vo.UserAndRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 多表分页模糊查询用户信息
     * 这里 @Param("ew") LambdaQueryWrapper<UserAndRole> query 对应 xml 的 ${ew.customSqlSegment} 参数
     * @param page 分页
     * @param userAndRole 模糊查询对象
     * @return 分页的用户信息
     */
    IPage<UserAndRole> selectUserAndRolepage(Page<UserAndRole> page, @Param("userAndRole") UserAndRole userAndRole);

}
