package com.agoni.system.utils;

import com.agoni.dgy.model.po.User;
import com.agoni.dgy.model.vo.AuthUserVo;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Slf4j
public class UserUtil {

    /**
     * 获取当前登录用户
     *
     * @return UserPrincipal
     */
    public static AuthUserVo getUserPrincipal() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        AuthUserVo authUserVo = null;
        try {
            authUserVo = (AuthUserVo) authentication.getPrincipal();
        } catch (Exception ignored) {

        }
        return authUserVo;
    }
    
    /**
     * 获取当前用户第一个权限
     * @return
     */
    public static String getFirstRole() {
        AuthUserVo userPrincipal = getUserPrincipal();
        for (GrantedAuthority authority : userPrincipal.getAuthorities()) {
            return authority.getAuthority();
        }
        return null;
    }
    
    /**
     * 判断当前用户是否有这个权限
     * @param role
     *
     * @return
     */
    public static boolean hasRole(String role){
        AuthUserVo userPrincipal = getUserPrincipal();
        for (GrantedAuthority authority : userPrincipal.getAuthorities()) {
            if (StringUtils.equals(authority.getAuthority(),role)){
                return true;
            }
        }
        return false;
    }

    /**
     * 获得当前用户
     * @return
     */
    public static User getUser() {
        User user = getUserPrincipal();
        return user;
    }
    
    /**
     * 活动用户账号
     * @return
     */
    public static String getUserName() {
        return getUserPrincipal().getUsername();
    }
    
    
    /**
     * 获得用户名字
     * @return
     */
    public static String getName() {
        return getUserPrincipal().getName();
    }
}
