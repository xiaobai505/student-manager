package com.agoni.security.constants;

import org.springframework.beans.factory.annotation.Value;

public final class SecurityConstants {
    /**
     * 角色的key
     **/
//    @Value("${JWT.SecurityKey}")
    public static final String SecurityKey = "dongyyds";

    /**
     * rememberMe 为 false 的时候过期时间是1个小时
     */
    public static final long Minute = 5;

    /**
     * rememberMe 为 true 的时候过期时间是7天
     */
    public static final long EXPIRATION_REMEMBER = 60 * 60 * 24 * 7L;

    // JWT token defaults
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";

    // System WHITELIST
    public static final String[] SYSTEM_WHITELIST = {
            "/auth/**",
    };

    // System WHITELIST
    public static final String[] SYSTEM_WHITELIST2 = {
            "/dgy/user/**",
    };

    public static final String[] SYSTEM_WHITELIST3 = {
            "/dgy/**",
    };

}
