package com.dogsong.event.order.listener;

import com.dogsong.event.order.MsgEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * MsgListener
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/22
 */
@Slf4j
@Component
public class MsgListener {


    @Async("defaultTaskExecutor")
    @SneakyThrows
    @EventListener(MsgEvent.class)
    public void sendMsg(MsgEvent event) {
        String orderId = event.getOrderId();

        long start = System.currentTimeMillis();

        log.info("开发发送短信");
        log.info("开发发送邮件");

        Thread.sleep(4000);

        long end = System.currentTimeMillis();

        log.info("{}: 发送短信、邮件耗时：({})毫秒", orderId, (end - start));
    }

}
