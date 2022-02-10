package com.agoni.dgy.service.impl;

import com.agoni.dgy.mapper.CourseUserMapper;
import com.agoni.dgy.model.po.CourseUser;
import com.agoni.dgy.model.vo.AuthUserVo;
import com.agoni.dgy.model.vo.CourseUserVo;
import com.agoni.dgy.service.CourseUserService;
import com.agoni.security.utils.UserUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户课程关系表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Service
@Slf4j
public class CourseUserServiceImpl extends ServiceImpl<CourseUserMapper, CourseUser> implements CourseUserService {

    @Autowired
    private CourseUserMapper courseUserMapper;

    @Override
    public List<CourseUserVo>mylist() {
        AuthUserVo userVo = UserUtil.getUser();
        SimpleGrantedAuthority admin = new SimpleGrantedAuthority("admin");
        if (userVo.getAuthorities().contains(admin)){
            log.info("我拥有管理员权限！查询所有！");
            return courseUserMapper.mylist(null);
        }
        List<CourseUserVo> mylist = courseUserMapper.mylist(userVo.getId());
        return mylist;
    }
}
