package com.dogsong.config;

import com.dogsong.utils.ThreadMdcUtil;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ThreadPoolConfig
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/25
 */
@Configuration
public class ThreadPoolConfig {

    @Value("${threadPool.corePoolSize:50}")
    private int corePoolSize;

    @Value("${threadPool.maxPoolSize:200}")
    private int maxPoolSize;

    @Value("${threadPool.queueCapacity:5000}")
    private int queueCapacity;

    @Bean("defaultTaskExecutor")
    public ThreadPoolTaskExecutor getExecutor() {
        //包装后的线程池，在执行方法前会设置traceId,执行后清空
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutorMdcWrapper();
        taskExecutor.setCorePoolSize(corePoolSize);
        taskExecutor.setMaxPoolSize(maxPoolSize);
        taskExecutor.setQueueCapacity(queueCapacity);
        taskExecutor.setThreadNamePrefix("default_thread_");

        // 拒绝策略
        taskExecutor.setRejectedExecutionHandler(new CustomRejectedExecutionHandler());

        return taskExecutor;
    }

    public static class ThreadPoolTaskExecutorMdcWrapper extends ThreadPoolTaskExecutor {

        @Override
        public void execute(Runnable task) {
            super.execute(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
        }

        @Override
        public void execute(Runnable task, long startTimeout) {
            super.execute(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()), startTimeout);
        }

        @Override
        public <T> Future<T> submit(Callable<T> task) {
            return super.submit(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
        }

        @Override
        public Future<?> submit(Runnable task) {
            return super.submit(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
        }

        @Override
        public ListenableFuture<?> submitListenable(Runnable task) {
            return super.submitListenable(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
        }

        @Override
        public <T> ListenableFuture<T> submitListenable(Callable<T> task) {
            return super.submitListenable(ThreadMdcUtil.wrap(task, MDC.getCopyOfContextMap()));
        }
    }


    public static class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("----- 线程池触发拒绝策略 -----");

            // 这里是引用了 CallerRunsPolicy 的逻辑
            // 触发拒绝策略的时候, 会使用调用者线程来执行
            // JDK文档描述: 这提供了一个简单的反馈控制机制，将降低新任务提交的速度
            if (!executor.isShutdown()) {
                r.run();
            }
        }

    }

}
