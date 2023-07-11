package com.agoni.security.controller;

import cn.hutool.core.util.StrUtil;
import com.agoni.core.cache.TokenCacheManger;
import com.agoni.security.utils.JwtTokenUtil;
import com.agoni.system.utils.UserUtil;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.impl.DefaultClock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static com.agoni.security.config.constants.SecurityConstants.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
@Slf4j
public class RedirectController {

    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private TokenCacheManger tokenCacheManger;

    private static final Clock CLOCK = DefaultClock.INSTANCE;
    @PostMapping("/refreshToken")
    public HashMap checkToken(String refreshToken){
        // 校验 refreshToken
        checkRefreshToken(refreshToken);
        // 生成新的 token
        String clientId = jwtTokenUtil.getClientId(refreshToken);
        String accessToken = jwtTokenUtil.generateToken(UserUtil.getUserName(), clientId);
        // 更新token过期时间，一般是不会过期的(还是更新一下)
        tokenCacheManger.refreshRefreshToken(REFRESH_TOKEN + ":" + UserUtil.getUserName());

        HashMap<String, Object> map = new HashMap<>(8);
        map.put(ACCESS_TOKEN, accessToken);
        map.put(REFRESH_TOKEN, refreshToken);
        // 过期时间
        Date expires = new Date(CLOCK.now().getTime() + 5 * MINUTE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss");
        map.put(EXPIRES, sdf.format(expires));
        return map;
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

}
