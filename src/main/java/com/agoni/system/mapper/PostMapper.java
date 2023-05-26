package com.agoni.system.mapper;

import com.agoni.system.model.po.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Admin
* @description 针对表【sys_post(岗位信息表)】的数据库操作Mapper
* @createDate 2022-08-31 15:44:43
* @Entity generator.domain.Post
*/
@Mapper
public interface PostMapper extends BaseMapper<Post> {

}




