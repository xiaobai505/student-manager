package com.agoni.core.factory;

import com.agoni.core.handler.GlobalUncaughtExceptionHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;

/**
 * 线程工厂
 *
 * @author t-guoyu.dong@pcitc.com
 * @since 2023/8/1
 */
@Slf4j
@AllArgsConstructor
public class MyThreadFactory implements ThreadFactory {

    private final ThreadFactory factory;
    @Override
    public Thread newThread(Runnable r) {
        Thread thread =factory.newThread(r);
        thread.setUncaughtExceptionHandler(new GlobalUncaughtExceptionHandler());
        return thread;
    }
}