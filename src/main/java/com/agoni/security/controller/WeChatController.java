package com.agoni.security.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/wechat")
@Slf4j
public class WeChatController {

    private WxMpService wxMpService;

    @Autowired
    public void setWxMpService(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }

    @GetMapping("/auth_url")
    public String getAuthUrl(@PathParam("redirectUrl") String redirectUrl) {
        redirectUrl = redirectUrl + "/wechat/invoke";
        try {
            redirectUrl = URLEncoder.encode(redirectUrl, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return wxMpService.getOAuth2Service()
                .buildAuthorizationUrl(redirectUrl, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
    }

    @ResponseBody
    @GetMapping("invoke")
    public Object weChatInvoke(HttpServletRequest httpServletRequest) {
        String code = httpServletRequest.getParameter("code");
        String state = httpServletRequest.getParameter("state");
        log.info("code:"+code);
        log.info("state"+state);

        return code+state;
    }

    @ResponseBody
    @GetMapping
    public Object test() throws WxErrorException {
        // 临时ticket
        //WxMpQrCodeTicket ticket = wxMpService.getQrcodeService().qrCodeCreateTmpTicket(scene, expire_seconds);
        WxMpQrCodeTicket ticket = wxMpService.getQrcodeService().qrCodeCreateTmpTicket(123, 123455);
        String url = wxMpService.getQrcodeService().qrCodePictureUrl(ticket.getTicket());
        return url;
    }

}
