package com.agoni.security.exception;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(HttpStatus.BAD_REQUEST.value());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .code(ExceptionType.TOKEN_CHECK_FAIL.getCode())
                .message(ExceptionType.TOKEN_CHECK_FAIL.getMessage())
                .build();
        response.getWriter().println(JSONObject.toJSONString(errorResponse));
        response.getWriter().flush();
    }
}
