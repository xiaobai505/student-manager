package com.agoni.security.utils;

import com.agoni.dgy.model.po.User;
import com.agoni.dgy.model.vo.AuthUserVo;
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
     * 获得当前用户
     * @return
     */
    public static AuthUserVo getUser() {
        AuthUserVo userPrincipal = getUserPrincipal();
        return userPrincipal;
    }
}
