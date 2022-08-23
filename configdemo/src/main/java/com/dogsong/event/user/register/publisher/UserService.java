package com.dogsong.event.user.register.publisher;

import com.dogsong.event.user.register.UserRegisterEvent;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * 实现 ApplicationEventPublisherAware 接口，从而将 ApplicationEventPublisher 注入到其中
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/22
 */
@Slf4j
@Service
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(@NonNull ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void register(String username) {
        // do ... 执行注册逻辑
        log.info("[register][执行用户({}) 的注册逻辑]", username);

        // 发布 event
        // 在执行完注册逻辑后，调用 ApplicationEventPublisher 的 #publishEvent(ApplicationEvent event) 方法，
        // 发布「UserRegisterEvent」事件
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this, username));
    }

}
