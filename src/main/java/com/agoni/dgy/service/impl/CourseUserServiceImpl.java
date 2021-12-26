package com.agoni.dgy.service.impl;

import com.agoni.dgy.model.po.CourseUser;
import com.agoni.dgy.mapper.CourseUserMapper;
import com.agoni.dgy.service.CourseUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户课程关系表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Service
public class CourseUserServiceImpl extends ServiceImpl<CourseUserMapper, CourseUser> implements CourseUserService {

}
