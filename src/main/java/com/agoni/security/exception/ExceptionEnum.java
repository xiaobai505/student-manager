package com.agoni.security.exception;

public enum ExceptionEnum {
    
    INNER_ERROR(500, "系统内部错误"),
    UNAUTHORIZED(401, "未登录"),
    BAD_REQUEST(400, "请求错误"),
    FORBIDDEN(403, "无权操作"),
    NOT_FOUND(404, "未找到"),
    USER_NAME_DUPLICATE(40001001, "用户名重复"),
    USER_NOT_FOUND(40401002, "用户不存在"),
    USER_PASSWORD_NOT_MATCH(40001003, "用户名或密码错误"),
    USER_NOT_ENABLED(50001001, "用户未启用"),
    USER_LOCKED(50001002, "用户被锁定"),
    TOKEN_CHECK_FAIL(50001003, "登录超时，请刷新页面重新登录!"),// TOKEN解析失败
    LOGIN_FAILURE(50001004, "登录失败");
    
    
    private final Integer code;
    
    private final String msg;
    
    
    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public Integer getCode() {
        return code;
    }
    
    public String getmsg() {
        return msg;
    }
}
