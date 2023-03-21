package com.agoni.system.utils;

import com.agoni.dgy.model.po.User;
import com.agoni.dgy.model.vo.AuthUserVo;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

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
        try {
            return (AuthUserVo) authentication.getPrincipal();
        } catch (Exception ignored) {
            return null;
        }
    }
    
    
    /**
     * 获得当前用户权限
     */
    public static List<String> getRoles() {
        AuthUserVo authUserVo = getUserPrincipal();
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority ga : authUserVo.getAuthorities()) {
            roles.add(ga.getAuthority());
        }
        return roles;
    }
    
    /**
     * 获取当前用户第一个权限
     * @return
     */
    public static String getFirstRole() {
        List<String> roles = getRoles();
        if (CollectionUtils.isNotEmpty(roles)) {
            return roles.get(0);
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
        if (ObjectUtils.isNotEmpty(getUserPrincipal())){
            return getUserPrincipal().getUsername();
        }
        return null;
    }
    
    
    /**
     * 获得用户名字
     * @return
     */
    public static String getName() {
        if (ObjectUtils.isNotEmpty(getUserPrincipal())){
            return getUserPrincipal().getName();
        }
        return null;
    }
}
