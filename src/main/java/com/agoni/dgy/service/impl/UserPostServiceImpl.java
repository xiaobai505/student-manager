package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.UserPostMapper;
import com.agoni.dgy.model.po.UserPost;
import com.agoni.dgy.service.UserPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【tb_user_post(用户与岗位关联表)】的数据库操作Service实现
* @createDate 2022-08-31 16:29:55
*/
@Service
public class UserPostServiceImpl extends ServiceImpl<UserPostMapper, UserPost>
    implements UserPostService{

}




