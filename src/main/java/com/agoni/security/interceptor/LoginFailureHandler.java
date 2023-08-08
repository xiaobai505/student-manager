package com.agoni.security.interceptor;

import com.agoni.system.service.LogininforService;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.agoni.core.exception.ResponseCodeEnum.LOGIN_FAILURE;

/**
 * 登录失败
 * @author Admin
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    
    @Resource
    private LogininforService logininforService;
    
    /**
     * Called when an authentication attempt fails.
     *
     * @param request   the request during which the authentication attempt occurred.
     * @param response  the response.
     * @param exception the exception which was thrown to reject the authentication
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {
        LOGIN_FAILURE.sendFailure(response);
        logininforService.asyncLogininfor("****", LOGIN_FAILURE);
    }
}
