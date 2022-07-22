package com.dogsong.event.order;

import com.dogsong.event.order.publisher.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderProductEventTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void buyOrderTest() {
        orderService.buyOrder("732171109");
    }

}