package com.dogsong.event.order.publisher;

import com.dogsong.event.order.MsgEvent;
import com.dogsong.event.order.OrderProductEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 订单服务
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/22
 */
@Slf4j
@Service
public class OrderService {

    @Autowired
    private ApplicationContext applicationContext;

    public void buyOrder(String orderId) {
        long start = System.currentTimeMillis();
        // 1.查询订单详情

        // 2.检验订单价格 （同步处理）
        applicationContext.publishEvent(new OrderProductEvent(this, orderId));

        // 3.短信通知（异步处理）
        applicationContext.publishEvent(new MsgEvent(orderId));

        long end = System.currentTimeMillis();
        log.info("任务全部完成，总耗时: ({})毫秒", end - start);
    }
}
