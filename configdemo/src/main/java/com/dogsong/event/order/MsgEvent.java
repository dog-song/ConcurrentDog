package com.dogsong.event.order;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * MsgEvent
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/22
 */
@Data
@AllArgsConstructor
public class MsgEvent {

    /** 该类型事件携带的信息 */
    public String orderId;

}