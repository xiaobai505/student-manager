package com.agoni.security.utils;

import com.agoni.dgy.model.po.User;
import com.sun.security.auth.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        //details里面可能存放了当前登录用户的详细信息，也可以通过cast后拿到
        User userDetails = (User) authenticationToken.getDetails();
        return userDetails;
    }
}
