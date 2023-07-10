package com.agoni.system.utils;

import com.agoni.core.diboot.Binder;
import com.agoni.system.model.po.User;
import com.agoni.system.model.vo.AuthUserVo;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

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
            AuthUserVo authUserVo = (AuthUserVo) authentication.getPrincipal();
            Binder.bindRelations(authUserVo);
            return authUserVo;
        } catch (Exception e) {
            log.error("UserPrincipal error: {}", e.getMessage());
            log.warn("只有定时任务时,UserPrincipal为空才正常");
            return null;
        }
    }
    
    
    /**
     * 获得当前用户权限
     */
    public static List<String> getRoles() {
        AuthUserVo authUserVo = getUserPrincipal();
        return authUserVo.getRoleCodes();
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
        List<String> roles = getRoles();
        if (roles.contains(role)){
            return true;
        }
        return false;
    }

    /**
     * 获得当前用户
     * @return
     */
    public static User getUser() {
        return getUserPrincipal();
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
