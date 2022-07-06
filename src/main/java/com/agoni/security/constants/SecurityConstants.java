package com.agoni.security.constants;

public final class SecurityConstants {
    /**
     * 角色的key
     **/
//    @Value("${JWT.SecurityKey}")
    public static final String SecurityKey = "dongyyds";
    /**
     * 分钟
     */
    public static final long Minute = 50;
    /**
     * rememberMe 为 true 的时候过期时间是7天
     */
    public static final long EXPIRATION_REMEMBER = 60 * 60 * 24 * 7L;
    // JWT token defaults
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    // 不校验的 URL
    public static final String[] SYSTEM_WHITELIST = {"/auth/**", "/wechat/**","/routes/**",
            "/swagger**/**", "/webjars/**", "/v3/**", "/doc.html"};
}
