package com.agoni.core.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 业务校验异常码
 *
 * @author t-guoyu.dong@pcitc.com
 * @since 2023/8/1
 */

@AllArgsConstructor
@Getter
public enum BusinessBaseEnum implements BaseEnum {
    BUSINESS_ERROR(1001, "{0}"),
    SYSTEM_ERROR(1001, "系统出小差了，请稍后再试哦~~"),
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
}