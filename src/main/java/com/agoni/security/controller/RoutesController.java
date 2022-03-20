package com.agoni.security.controller;

import com.agoni.dgy.model.vo.AuthUserVo;
import com.agoni.security.utils.UserUtil;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routes")
@Slf4j
@Api(tags = "动态路由")
public class RoutesController {
    @GetMapping
    @ApiOperation("获取用户")
    public JSONObject get() {
        JSONObject json = new JSONObject();
        json.put("systemRouter","");

        json.put("permissionRouter","systemRouter");
        json.put("frameRouter","systemRouter");
        json.put("tabsRouter","systemRouter");
        return json;
    }
}
