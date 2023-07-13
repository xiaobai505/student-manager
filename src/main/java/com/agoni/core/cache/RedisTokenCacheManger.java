package com.agoni.core.cache;

import com.agoni.security.config.constants.JwtConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis token缓存管理器
 *
 * @author t-guoyu.dong@pcitc.com
 * @since 2023/7/10
 */
@Component
@ConditionalOnProperty(value = "spring.cache.type", havingValue = "redis", matchIfMissing = true)
public class RedisTokenCacheManger implements TokenCacheManger {
    @Resource
    private JwtConfiguration jwtConfiguration;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String getAccessToken(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public String getRefreshToken(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void putAccessToken(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value, jwtConfiguration.getAccessExpireTime(), TimeUnit.SECONDS);
    }

    @Override
    public void putRefreshToken(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value, jwtConfiguration.getRefreshExpireTime(), TimeUnit.SECONDS);
    }

    @Override
    public void evictToken(Set<String> keys) {
        stringRedisTemplate.delete(keys);
    }

    @Override
    public Set<String> accessTokenKeys(String key) {
        return stringRedisTemplate.keys(key);
    }

}