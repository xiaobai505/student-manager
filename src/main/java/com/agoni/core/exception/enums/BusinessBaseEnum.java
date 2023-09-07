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

    BUSINESS_ERROR(1001, "业务报错！"),
    START_ERROR(1001, "启动命令参数缺少，未能获取当前用户！"),
    DEPT_STOP(1001, "部门停用，不允许新增用户"),
    SYSTEM_ERROR(1001, "系统出小差了，请稍后再试哦~~"),
    STOCK_NULL(1001, "库存不足"),
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