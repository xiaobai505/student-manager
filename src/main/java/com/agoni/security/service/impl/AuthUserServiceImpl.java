package com.agoni.security.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.agoni.core.cache.TokenCacheManger;
import com.agoni.core.diboot.Binder;
import com.agoni.core.exception.BusinessException;
import com.agoni.security.config.constants.JwtConfiguration;
import com.agoni.security.model.TokenVo;
import com.agoni.security.service.AuthUserService;
import com.agoni.security.utils.JwtTokenUtil;
import com.agoni.system.model.po.User;
import com.agoni.system.model.vo.AuthUserVo;
import com.agoni.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.agoni.core.exception.enums.httpEnum.TOKEN_CHECK_FAIL;
import static com.agoni.security.config.constants.SecurityConstants.ACCESS_TOKEN;
import static com.agoni.security.config.constants.SecurityConstants.REFRESH_TOKEN;

/**
 * @author Admin
 */
@Slf4j
@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Resource
    private UserService userService;
    @Resource
    private UserCache userCache;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private JwtConfiguration jwtConfiguration;
    @Resource
    private TokenCacheManger tokenCacheManger;

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public AuthUserVo loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername:  username: " + username);
        // 1: 根据用户名拿到用户信息
        User user = userService.getUserByUserName(username);
        // 2：根据用户id查询权限
        AuthUserVo authUserVo = Binder.convertAndBindRelations(user, AuthUserVo.class);
        // 3：把用户放入到缓存
        userCache.putUserInCache(authUserVo);
        return authUserVo;
    }

    @Override
    public TokenVo refreshToken(String refreshToken) {
        String userName = getUserName(refreshToken);
        AuthUserVo authUserVo = this.loadUserByUsername(userName);
        String clientId = JwtTokenUtil.getClientId(refreshToken);
        return getTokenVo(authUserVo, clientId);
    }

    /**
     * 校验 refreshToken 在JWT中是否过期
     * @param refreshToken
     * @return userName
     */
    private String getUserName(String refreshToken) {
        try {
            String userName = JwtTokenUtil.getUserName(refreshToken);
            String clientId = JwtTokenUtil.getClientId(refreshToken);
            // 看下redis里面有没有这个refreshToken
            String refreshTokenStr = tokenCacheManger.getRefreshToken(REFRESH_TOKEN + "::" + userName + "::" + clientId);
            if (StrUtil.isBlank(refreshTokenStr)) {
                log.error(" <refreshToken>过期了,redis也删除了!");
                throw new BusinessException(TOKEN_CHECK_FAIL);
            }
            if (!StrUtil.equals(refreshTokenStr, refreshToken)) {
                log.error(" <refreshToken>过期了, 但redis里面是新生成的");
                throw new BusinessException(TOKEN_CHECK_FAIL);
            }
            return userName;
        }catch (Exception e){
            throw new BusinessException(TOKEN_CHECK_FAIL);
        }
    }

    @Override
    public TokenVo getTokenVo(AuthUserVo authUserVo, String clientId) {
        String userName = authUserVo.getUsername();
        // accessToken 和 refreshToken
        String accessToken = jwtTokenUtil.generateToken(userName, clientId);
        DateTime expirationDate = DateUtil.offsetSecond(DateUtil.date(), jwtConfiguration.getRefreshExpireTime() * 2);
        String refreshToken = jwtTokenUtil.generateToken(REFRESH_TOKEN + ":" + userName, clientId, expirationDate);
        // 保存到redis
        String accessKey = ACCESS_TOKEN + "::" + userName + "::" + clientId;
        String refreshKey = REFRESH_TOKEN + "::" + userName + "::" + clientId;
        tokenCacheManger.putAccessToken(accessKey, accessToken);
        tokenCacheManger.putRefreshToken(refreshKey, refreshToken);

        // 当前时间偏移 jwtConfiguration.getAccessExpireTime() 后为过期时间
        DateTime expires = DateUtil.offsetSecond(DateUtil.date(), jwtConfiguration.getAccessExpireTime());
        return TokenVo.builder().username(userName).accessToken(accessToken)
                .refreshToken(refreshToken).expires(expires).roles(authUserVo.getRoleCodes()).build();
    }
}
