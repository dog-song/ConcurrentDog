package com.dogsong.event.order;

import lombok.ToString;
import org.springframework.context.ApplicationEvent;

/**
 * OrderProductEvent
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/22
 */
@ToString
public class OrderProductEvent extends ApplicationEvent {

    private String orderId;


    public OrderProductEvent(Object source) {
        super(source);
    }

    public OrderProductEvent(Object source, String orderId) {
        super(source);
        this.orderId = orderId;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
