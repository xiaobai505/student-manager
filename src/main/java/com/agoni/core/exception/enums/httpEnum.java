package com.agoni.core.exception.enums;

import cn.hutool.http.ContentType;
import com.agoni.security.model.TokenVo;
import com.agoni.system.model.response.ResponseEntity;
import com.alibaba.fastjson2.JSON;
import com.google.common.base.Charsets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author gyd
 */

@AllArgsConstructor
@Getter
public enum httpEnum implements BaseEnum {
    LOGIN_SUCCESS(0,"登录成功"),
    LOGIN_FAILURE(1, "登录失败"),
    INNER_ERROR(501, "系统内部错误"),
    UNAUTHORIZED(401, "未登录"),
    BAD_REQUEST(400, "请求错误"),
    FORBIDDEN(403, "无权操作"),
    NOT_FOUND(404, "未找到"),
    PASSWORD_FAIL(501001, "原密码错误!"),
    /**
     * "refreshToken 校验失败，需要重新登录！会清空缓冲，返回登录页面！"
     */
    TOKEN_CHECK_FAIL(5001003, "登录超时，请刷新页面重新登录!"),
    ;
    
    private final Integer code;
    private final String msg;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void sendSuccess(HttpServletResponse response, TokenVo vo) throws IOException {
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(ContentType.JSON.toString(Charsets.UTF_8));
        response.getWriter().write(JSON.toJSONString(ResponseEntity.body(vo)));
    }


    public void sendFail(HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.BAD_GATEWAY.value());
        response.setContentType(ContentType.JSON.toString(Charsets.UTF_8));
        response.getWriter().write(JSON.toJSONString(ResponseEntity.fail(this)));
    }
}
