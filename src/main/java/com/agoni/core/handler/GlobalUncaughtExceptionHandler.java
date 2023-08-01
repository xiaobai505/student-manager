package com.agoni.core.handler;

import lombok.extern.slf4j.Slf4j;

/**
 * 全局未捕获异常处理器
 *
 * @author t-guoyu.dong@pcitc.com
 * @since 2023/8/1
 */
@Slf4j
public class GlobalUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        log.error("Exception in thread {} ", t.getName(), e);
    }
}