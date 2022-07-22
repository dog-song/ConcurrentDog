package com.dogsong.event.order.listener;

import com.dogsong.event.order.OrderProductEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 实现 ApplicationListener 接口，并指定监听的事件类型
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/22
 */
@Slf4j
@Component
public class OrderProductListener implements ApplicationListener<OrderProductEvent> {


    @SneakyThrows
    @Override
    public void onApplicationEvent(OrderProductEvent event) {
        String orderId = event.getOrderId();
        long start = System.currentTimeMillis();

        Thread.sleep(2000);

        long end = System.currentTimeMillis();

        log.info("{}: 校验订单商品价格耗时: ({})毫秒", orderId, (end - start));
    }

}
