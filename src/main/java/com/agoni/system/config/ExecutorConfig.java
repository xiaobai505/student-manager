package com.agoni.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ExecutorConfig {
    public static final int CORE_POOL_SIZE = 5;
    public static final int MAX_POOL_SIZE = 10;
    public static final int QUEUE_CAPACITY = 100;
    
    
    @Bean("dgy")
    public ThreadPoolTaskExecutor asyncApproveExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 配置核心线程数
        executor.setCorePoolSize(CORE_POOL_SIZE);
        // 配置最大线程
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        // 配置队列大小
        executor.setQueueCapacity(Integer.MAX_VALUE);
        // 配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("dgy-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
    
    @Bean("mvc")
    public ThreadPoolTaskExecutor mvcTaskExecutor() {
        ThreadPoolTaskExecutor mvc = new ThreadPoolTaskExecutor();
        // 配置核心线程数
        mvc.setCorePoolSize(CORE_POOL_SIZE);
        // 配置最大线程
        mvc.setMaxPoolSize(MAX_POOL_SIZE);
        // 配置队列大小
        mvc.setQueueCapacity(QUEUE_CAPACITY);
        // 配置线程池中的线程的名称前缀
        mvc.setThreadNamePrefix("mvc-");
        return mvc;
    }
}
