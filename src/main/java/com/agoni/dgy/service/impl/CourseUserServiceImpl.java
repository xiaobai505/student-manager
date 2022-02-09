package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.CourseUserMapper;
import com.agoni.dgy.model.po.CourseUser;
import com.agoni.dgy.model.vo.AuthUserVo;
import com.agoni.dgy.service.CourseUserService;
import com.agoni.security.utils.UserUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<CourseUser> mylist() {
        AuthUserVo userVo = UserUtil.getUser();
        QueryWrapper<CourseUser> wrapper=new QueryWrapper();
        wrapper.lambda().eq(CourseUser::getUserId,userVo.getId());
        List<CourseUser> list = this.list(wrapper);
        return list;
    }
}
