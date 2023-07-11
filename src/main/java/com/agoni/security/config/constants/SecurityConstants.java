package com.agoni.security.config.constants;

public final class SecurityConstants {
    
    /**
     * 分钟
     */
    public static final long MINUTE = 60 * 1000L;
    /**
     * Bearer 开头的token
     */
    public static final String TOKEN_PREFIX = "Bearer ";
    /**
     * 过期时间
     */
    public static final String EXPIRES ="expires";
    /**
     * 存放访问token的key前缀
     */
    public static final String ACCESS_TOKEN = "accessToken";
    /**
     * 存放刷新token的key前缀
     */
    public static final String REFRESH_TOKEN = "refreshToken";
    // 不校验的 URL
    public static final String[] SYSTEM_WHITELIST = {"/auth/**", "/wechat/**","/routes/**",
            "/swagger**/**", "/webjars/**", "/v3/**", "/doc.html","/dgy/result/**"};
}