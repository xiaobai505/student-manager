package com.agoni.dgy.mapper;

import com.agoni.dgy.model.po.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Admin
* @description 针对表【tb_post(岗位信息表)】的数据库操作Mapper
* @createDate 2022-08-31 15:44:43
* @Entity generator.domain.Post
*/
@Mapper
public interface PostMapper extends BaseMapper<Post> {

}




