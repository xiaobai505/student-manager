package com.agoni.security.controller;

import com.agoni.core.cache.TokenCacheManger;
import com.agoni.security.utils.JwtTokenUtil;
import com.agoni.system.utils.UserUtil;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.impl.DefaultClock;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static com.agoni.security.config.constants.SecurityConstants.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class RedirectController {

    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private TokenCacheManger tokenCacheManger;

    private static final Clock CLOCK = DefaultClock.INSTANCE;
    @PostMapping("/refreshToken")
    public HashMap checkToken(String refreshToken){
        String refresh = tokenCacheManger.getAccessToken(refreshToken);

        HashMap<String, Object> map = new HashMap<>(8);
        String accessToken = jwtTokenUtil.generateToken(UserUtil.getUserName(), IdWorker.getIdStr());
        map.put(ACCESS_TOKEN, accessToken);
        map.put(REFRESH_TOKEN, refreshToken);
        // 过期时间
        Date expires = new Date(CLOCK.now().getTime() + 5 * MINUTE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/ HH:mm:ss");
        map.put(EXPIRES, sdf.format(expires));
        return map;
    }

    @GetMapping("/test")
    public boolean checkToken(){
        return true;
    }
}
