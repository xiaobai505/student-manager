package com.agoni.core.threadExecutor;

import com.agoni.core.factory.MyThreadFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池
 * @author gyd
 */
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
        // 满了调用线程执行，认为重要任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.setThreadFactory(new MyThreadFactory(executor));
        //执行初始化
        executor.initialize();
        return executor;
    }

    @Bean("dgy2")
    public ThreadPoolTaskExecutor websocketExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 配置核心线程数
        executor.setCorePoolSize(CORE_POOL_SIZE);
        // 配置最大线程
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        // 配置队列大小
        executor.setQueueCapacity(Integer.MAX_VALUE);
        // 配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("dgy2-");
        // 支持同时推送1000人
        executor.setQueueCapacity(QUEUE_CAPACITY);
        // 满了直接丢弃，默认为不重要消息推送
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        executor.setThreadFactory(new MyThreadFactory(executor));
        // 执行初始化
        executor.initialize();
        return executor;
    }
}
