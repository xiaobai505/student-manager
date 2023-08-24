package com.agoni.security.service;

import com.agoni.security.model.TokenVo;
import com.agoni.system.model.vo.AuthUserVo;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author gyd
 */

public interface AuthUserService extends UserDetailsService {
    /***
     * 更新refreshToken
     *
     * @param refreshToken refreshToken
     * @return com.agoni.security.model.TokenVo
     * @author t-guoyu.dong@pcitc.com
     * @date 2023-07-13
     */
    TokenVo refreshToken(String refreshToken);

    /***
     * 生成tokenVo
     *
     * @param authUserVo authUserVo
     * @param clientId clientId
     * @return com.agoni.security.model.TokenVo
     * @author t-guoyu.dong@pcitc.com
     * @date 2023-07-13
     */
    TokenVo getTokenVo(AuthUserVo authUserVo, String clientId);
}
