package com.agoni.security.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/wechat")
@Slf4j
@Api(tags="微信")
public class WeChatController {

    private WxMpService wxMpService;


    @Autowired
    public void setWxMpService(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @GetMapping("/auth_url")
    @ApiOperation("用户跳转微信授权")
    public String getAuthUrl() throws UnsupportedEncodingException {
        String redirectUrl ="http://225h70r656.wicp.vip/wechat/invoke";
        return wxMpService.getOAuth2Service().buildAuthorizationUrl(redirectUrl, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
    }

    @ResponseBody
    @GetMapping("invoke")
    @ApiOperation("微信用户授权后回调接口")
    public Object weChatInvoke(HttpServletRequest httpServletRequest) {
        String code = httpServletRequest.getParameter("code");
        log.info("code:"+code);
        try {
            WxOAuth2AccessToken wxOAuth2AccessToken = wxMpService.getOAuth2Service().getAccessToken(code);
            WxOAuth2UserInfo userInfo = wxMpService.getOAuth2Service().getUserInfo(wxOAuth2AccessToken, null);
            return userInfo;
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ResponseBody
    @GetMapping
    @ApiOperation("生成一个二维码")
    public Object test() throws WxErrorException {
        WxMpQrCodeTicket ticket = wxMpService.getQrcodeService().qrCodeCreateTmpTicket(123, 123455);
        File file = wxMpService.getQrcodeService().qrCodePicture(ticket);
        return file;
    }

}
