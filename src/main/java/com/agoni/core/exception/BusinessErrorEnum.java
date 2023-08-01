package com.agoni.core.exception;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 业务校验异常码
 *
 * @author t-guoyu.dong@pcitc.com
 * @since 2023/8/1
 */

@AllArgsConstructor
public enum BusinessErrorEnum implements ErrorEnum{
    BUSINESS_ERROR(1001, "{0}"),
    SYSTEM_ERROR(1001, "系统出小差了，请稍后再试哦~~"),
    ;

    private final Integer code;
    private final String msg;

    private static final Map<Integer, BusinessErrorEnum> cache;

    static {
        cache = Arrays.stream(BusinessErrorEnum.values()).collect(Collectors.toMap(BusinessErrorEnum::getErrorCode, Function.identity()));
    }

    public static BusinessErrorEnum of(Integer type) {
        return cache.get(type);
    }

    @Override
    public Integer getErrorCode() {
        return code;
    }

    @Override
    public String getErrorMsg() {
        return msg;
    }
}