package com.agoni.security.Interceptor;

import com.agoni.security.exception.ErrorResponse;
import com.agoni.security.exception.ExceptionType;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败
 * @author Admin
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
    /**
     * Called when an authentication attempt fails.
     *
     * @param request   the request during which the authentication attempt occurred.
     * @param response  the response.
     * @param exception the exception which was thrown to reject the authentication
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.BAD_REQUEST.value());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(ExceptionType.UNAUTHORIZED.getCode())
                .message(ExceptionType.UNAUTHORIZED.getMessage())
                .build();
        response.getWriter().write(JSONObject.toJSONString(errorResponse));
    }
}
