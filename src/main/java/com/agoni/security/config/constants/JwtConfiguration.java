package com.agoni.security.config.constants;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * jwt配置
 *
 * @author Star Walker
 * @date 2019/12/26
 */
@Data
@Configuration
@ConfigurationProperties("jwt")
public class JwtConfiguration {

    /**
     * jwt token的头
     */
    private String header;

    /**
     * jwt加密秘钥
     */
    private String secret;

    /**
     * jwt解密秘钥
     */
    private String decrypt;

    /**
     * 失效时间-秒
     */
    private Integer expiration;

    /**
     * token存储在redis的有效时间
     */
    private Integer expireTime;

    /**
     * refreshToken存储在redis的存在时间
     */
    private Integer refreshExpireTime;

    /**
     * 是否检查token过期
     */
    private Boolean checkExpired;

    /**
     * 是否允许一个账号多个设备登录
     */
    private Boolean multipleLogin;

}
