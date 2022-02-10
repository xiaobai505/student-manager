package com.agoni.dgy.mapper;

import com.agoni.dgy.model.po.CourseUser;
import com.agoni.dgy.model.vo.CourseUserVo;
import com.agoni.dgy.model.vo.UserAndRole;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户课程关系表 Mapper 接口
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Mapper
public interface CourseUserMapper extends BaseMapper<CourseUser> {

    List<CourseUserVo> mylist(@Param("id") Long id);

}
