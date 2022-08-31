package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.PostMapper;
import com.agoni.dgy.model.po.Post;
import com.agoni.dgy.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【tb_post(岗位信息表)】的数据库操作Service实现
* @createDate 2022-08-31 15:44:43
*/
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
    implements PostService{

}




