package com.dogsong.event.user.register.listener;

import com.dogsong.event.user.register.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * CouponService
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/22
 */
@Slf4j
@Service
public class CouponService {

    /**
     * 在方法上，添加 @EventListener 注解，并设置监听的事件为 UserRegisterEvent。(另一种使用方式)
     *
     * 添加 @Order 制定执行的顺序
     *
     * @param event 监听的事件
     */
    @Order(1)
    @EventListener
    public void addCoupon(UserRegisterEvent event) {

        log.info("[addCoupon][给用户({}) 发放优惠劵]", event.getUsername());

    }

}
