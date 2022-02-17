package com.agoni.dgy.mapper;

import com.agoni.dgy.model.po.CourseUser;
import com.agoni.dgy.model.vo.CourseUserVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
