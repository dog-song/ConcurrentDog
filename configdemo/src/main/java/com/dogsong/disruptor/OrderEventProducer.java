package com.dogsong.disruptor;

import com.lmax.disruptor.RingBuffer;

/**
 * OrderEventProducer
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/2/15
 */
public class OrderEventProducer {

    private final RingBuffer<OrderEvent> ringBuffer;

    public OrderEventProducer(RingBuffer<OrderEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(String orderId) {
        long sequence = ringBuffer.next();
        try {
            OrderEvent orderEvent = ringBuffer.get(sequence);
            orderEvent.setId(orderId);
        } finally {
            ringBuffer.publish(sequence);
        }
    }

}
