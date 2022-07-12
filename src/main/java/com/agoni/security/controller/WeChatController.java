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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/wechat")
@Slf4j
@Api(tags="微信")
public class WeChatController {
    
    public static final String CODE = "code";
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
    @ApiOperation("回调接口，获得用户信息")
    public Object weChatInvoke(HttpServletRequest httpServletRequest) {
        String code = httpServletRequest.getParameter(CODE);
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


    @GetMapping
    @ApiOperation("二维码Url")
    public Object pictureUrl() throws WxErrorException {
        WxMpQrCodeTicket ticket = wxMpService.getQrcodeService().qrCodeCreateTmpTicket(123, 123455);
        return wxMpService.getQrcodeService().qrCodePictureUrl(ticket.getTicket());
    }

    @ResponseBody
    @GetMapping("/file")
    @ApiOperation("二维码图片")
    public Object pictureFile() throws WxErrorException {
        WxMpQrCodeTicket ticket = wxMpService.getQrcodeService().qrCodeCreateTmpTicket(123, 123455);
        return wxMpService.getQrcodeService().qrCodePicture(ticket);
    }

}
