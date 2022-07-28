package com.dogsong.event.user.register.listener;

import com.dogsong.event.user.register.UserRegisterEvent;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * EmailService
 *
 * 1. 实现 ApplicationListener 接口，通过 E 泛型设置感兴趣的事件;
 * 2. 实现 #onApplicationEvent(E event) 方法，针对监听的 UserRegisterEvent 事件，进行自定义处理;
 * 3. 设置 @Async 注解，声明异步执行。毕竟实际场景下，发送邮件可能比较慢，又是非关键逻辑。
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/22
 */
@Slf4j
@Service
public class EmailService implements ApplicationListener<UserRegisterEvent> {

    /**
     * onApplicationEvent 方法对消息进行接收处理
     *
     */
    @SneakyThrows
    @Async("defaultTaskExecutor")
    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        log.info("[onApplicationEvent][给用户({}) 发送邮件]", event.getUsername());
    }

}
