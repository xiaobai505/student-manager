package com.agoni.core.cache;

import java.util.Set;

/**
 * @author gyd
 */
public interface TokenCacheManger {

    /**
     * 获取AccessToken
     *
     * @param key key
     * @return token
     */
    String getAccessToken(String key);

    /**
     * 获取RefreshToken
     *
     * @param key key
     * @return token
     */
    String getRefreshToken(String key);

    /**
     * 保存AccessToken
     *
     * @param key   key
     * @param value token
     */
    void putAccessToken(String key, String value);

    /**
     * 保存AccessToken
     *
     * @param key   key
     * @param value token
     */
    void putRefreshToken(String key, String value);

    /**
     * 排除Token
     *
     * @param key key
     */
    void evictToken(Set<String> key);


    /**
     * 获取 accessTokenKeys
     *
     * @param key 命名空间
     * @return key集合
     */
    Set<String> accessTokenKeys(String key);
}
