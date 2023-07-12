package com.agoni.security.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.agoni.core.cache.TokenCacheManger;
import com.agoni.security.config.constants.JwtConfiguration;
import com.agoni.security.model.TokenFrom;
import com.agoni.security.model.TokenVo;
import com.agoni.security.utils.JwtTokenUtil;
import com.agoni.system.response.ResponseEntity;
import com.agoni.system.utils.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.agoni.security.config.constants.SecurityConstants.REFRESH_TOKEN;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class RedirectController {

    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private TokenCacheManger tokenCacheManger;

    @Resource
    private JwtConfiguration jwtConfiguration;

    @PostMapping("/refreshToken")
    public ResponseEntity<TokenVo> checkToken(@Validated @RequestBody TokenFrom tokenFrom) {
        // 校验 refreshToken
        checkRefreshToken(tokenFrom.getRefreshToken());
        // 获取 clientId
        String clientId = JwtTokenUtil.getClientId(tokenFrom.getRefreshToken());
        String userName = JwtTokenUtil.getUserName(tokenFrom.getRefreshToken());
        // 生成新的 token
        String accessToken = jwtTokenUtil.generateToken(userName, clientId);
        // 没必要在更新 refreshToken，过期就没办法解析了。

        // 当前时间偏移 jwtConfiguration.getAccessExpireTime() 后为过期时间
        DateTime expires = DateUtil.offsetMillisecond(DateUtil.date(), jwtConfiguration.getAccessExpireTime());
        TokenVo build = TokenVo
                .builder()
                .accessToken(accessToken)
                .refreshToken(tokenFrom.getRefreshToken())
                .expires(expires)
                .build();
        return ResponseEntity.body(build);
    }

    private void checkRefreshToken(String refreshToken) {
        // 看下redis里面有没有这个refreshToken
        String refreshTokenStr = tokenCacheManger.getRefreshToken(REFRESH_TOKEN + ":" + UserUtil.getUserName());
        // 拿了一个很久以前的refreshToken来,redis里面都已经自动删除了,就会为空
        if (StrUtil.isBlank(refreshTokenStr)) {
            log.error("拿了一个很久以前的refreshToken来,redis里面都已经自动删除了,就会为空");
        }
        // 拿一个很久以前的refreshToken来,但redis里面是新生成的
        if (!StrUtil.equals(refreshTokenStr, refreshToken)) {
            log.error("拿一个很久以前的refreshToken来,但redis里面是新生成的");
        }
    }

    @PostMapping("/test")
    public String checkToken2(String refreshToken){
        return "ok";
    }

}
