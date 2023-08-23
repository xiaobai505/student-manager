package com.agoni.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.agoni.core.diboot.Binder;
import com.agoni.core.exception.BusinessException;
import com.agoni.core.omp.OmpServiceImpl;
import com.agoni.dgy.model.query.PwdQuery;
import com.agoni.system.mapper.UserMapper;
import com.agoni.system.model.po.User;
import com.agoni.system.model.query.UserQuery;
import com.agoni.system.model.vo.UserVo;
import com.agoni.system.service.DeptService;
import com.agoni.system.service.UserService;
import com.agoni.system.utils.UserUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.agoni.core.exception.enums.httpEnum.PASSWORD_FAIL;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author dgy
 * @since 2021-12-22
 */
@Service
@Slf4j
public class UserServiceImpl extends OmpServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private DeptService deptService;

    @Override
    public IPage<UserVo> pageUser(UserQuery userQuery) {
        // 获取当前用户的部门及子部门
        List<Long> deptIds = deptService.getChildDeptIds(userQuery.getDeptId());
        Page<User> page = Page.of(userQuery.getCurrentPage(), userQuery.getPageSize());
        QueryWrapper<User> userQueryWrapper = fillQueryWrapper(userQuery);
        // 增加 .or() 部门条件
        userQueryWrapper.lambda().or().in(CollUtil.isNotEmpty(deptIds), User::getDeptId, deptIds);
        return Binder.convertAndBindRelations(page(page, userQueryWrapper), UserVo.class);
    }

    /**
     * 获取用户用户名
     *
     * @param username 用户名
     *
     * @return {@link User}
     */
    @Override
    public User getUserByUserName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername,username);
        return getOne(queryWrapper);
    }
    
    /**
     * @return
     */
    @Override
    public boolean resetPwd(PwdQuery pq) {
        User user = UserUtil.getUser();
        if (pq.getUserId() == null && !StringUtils.equals(pq.getOldPassword(), user.getPassword())) {
            throw new BusinessException(PASSWORD_FAIL);
        }
        // 当前用户密码
        User u = User.builder().password(pq.getConfirmPassword()).build();
        u.setId(pq.getUserId() == null ? user.getId() : pq.getUserId());
        return updateById(u);
    }
    
    private LambdaQueryWrapper<User> getUserLambdaQueryWrapper(User user) {
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(User::getName,user.getName());
        return queryWrapper;
    }

}
