package com.dogsong.disruptor;

import cn.hutool.core.lang.UUID;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * DisruptorDemo
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/2/15
 */
@Slf4j
public class DisruptorDemo {

    public static void main(String[] args) {
        // 构造 disruptor
        Disruptor<OrderEvent> disruptor = new Disruptor<>(
                OrderEvent::new,
                // 指定 RingBuffer 大小, 必须是 2 的 N 次方
                1024 * 1024,
                Executors.defaultThreadFactory(),
                // 生产者类型
                ProducerType.MULTI,
                new YieldingWaitStrategy()
        );

        // 注册事件处理器
        // 单个消费者
        // disruptor.handleEventsWith(new OrderEventHandler());

        disruptor.handleEventsWithWorkerPool(new OrderEventHandler(), new OrderEventHandler());

        // 启动Disruptor
        disruptor.start();

        // 获取 ringBuffer
        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        // 生产 event
        OrderEventProducer eventProducer = new OrderEventProducer(ringBuffer);

        // 创建一个线程池，模拟多个生产者
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            fixedThreadPool.execute(() -> eventProducer.onData(UUID.randomUUID().toString()));
        }

    }

}
