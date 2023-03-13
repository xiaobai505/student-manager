package com.agoni.dgy.mapper;

import com.agoni.dgy.model.po.UserPost;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Admin
* @description 针对表【sys_user_post(用户与岗位关联表)】的数据库操作Mapper
* @createDate 2022-08-31 16:29:55
* @Entity generator.domain.UserPost
*/
@Mapper
public interface UserPostMapper extends BaseMapper<UserPost> {

}




