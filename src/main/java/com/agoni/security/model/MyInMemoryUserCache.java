package com.agoni.security.model;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.agoni.dgy.model.vo.AuthUserVo;
import com.agoni.security.service.AuthUserService;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class MyInMemoryUserCache implements UserCache {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public UserDetails getUserFromCache(String username) {
        String jsonStr = stringRedisTemplate.opsForValue().get("user::" + username);
        // JSONUtil.toBean 转换报错，狗日的卡了两天
        // JSONUtil.toBean(jsonStr, AuthUserVo.class);
        return JSONObject.parseObject(jsonStr, AuthUserVo.class);
    }

    @Override
    public void putUserInCache(UserDetails user) {
        stringRedisTemplate.opsForValue().set("user::" + user.getUsername(),
                JSONUtil.toJsonStr(user), 86400, TimeUnit.SECONDS);
    }

    @Override
    public void removeUserFromCache(String username) {
        stringRedisTemplate.delete("user::" + username);
    }
}
