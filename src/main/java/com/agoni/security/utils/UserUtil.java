package com.agoni.security.utils;

import com.agoni.dgy.model.po.User;
import com.sun.security.auth.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@Slf4j
public class UserUtil {

    /**
     * 获取当前登录用户
     *
     * @return UserPrincipal
     */
    public static UserPrincipal getUserPrincipal() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        UserPrincipal principal = null;
        try {
            principal = (UserPrincipal) authentication.getPrincipal();
        } catch (Exception ignored) {

        }
        return principal;
    }

    /**
     * 获得当前用户
     * @return
     */
    public static User getUser() {
        UserPrincipal userPrincipal = getUserPrincipal();
        return null;
    }
}
