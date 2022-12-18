package com.agoni.security.service.impl;

import com.agoni.dgy.model.po.User;
import com.agoni.dgy.model.vo.AuthUserVo;
import com.agoni.dgy.model.vo.RoleUserVo;
import com.agoni.dgy.service.RoleUserService;
import com.agoni.dgy.service.UserService;
import com.agoni.security.service.AuthUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Admin
 */
@Slf4j
@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleUserService roleUserService;
    

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public AuthUserVo loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername:  username: " + username);
        // 1: 根据用户名拿到用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername,username);
        User user = userService.getOne(queryWrapper);
        // 2： 根据用户id查询权限
        List<RoleUserVo> authlist = roleUserService.getRolebyUserId(user.getId());
        List<String> codeList = authlist.stream().map(RoleUserVo::getRoleCode).collect(Collectors.toList());
        Iterator<String> iterator = codeList.iterator();
        List<SimpleGrantedAuthority> roles= new ArrayList<>();
        while (iterator.hasNext()){
            roles.add(new SimpleGrantedAuthority(iterator.next().toUpperCase()));
        }
        AuthUserVo authUserVo = AuthUserVo.create(user, roles);
        
        //设置权限和角色
        // 1. commaSeparatedStringToAuthorityList放入角色时需要加前缀ROLE_，而在controller使用时不需要加ROLE_前缀
        // 2. 放入的是权限时，不能加ROLE_前缀，hasAuthority与放入的权限名称对应即可
        //AuthUserVo authUserVo = AuthUserVo.create(user, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"+",r,w"));
        return authUserVo;
    }
}
