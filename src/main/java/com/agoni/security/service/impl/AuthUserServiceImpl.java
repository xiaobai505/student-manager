package com.agoni.security.service.impl;

import com.agoni.core.diboot.Binder;
import com.agoni.security.service.AuthUserService;
import com.agoni.system.model.po.User;
import com.agoni.system.model.vo.AuthUserVo;
import com.agoni.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Admin
 */
@Slf4j
@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private UserService userService;
    @Resource
    private UserCache userCache;

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
        User user = userService.getUserByUserName(username);
        // 2：根据用户id查询权限
        AuthUserVo authUserVo = Binder.convertAndBindRelations(user, AuthUserVo.class);
        // 3：把用户放入到缓存
        userCache.putUserInCache(authUserVo);
        return authUserVo;
    }
}
