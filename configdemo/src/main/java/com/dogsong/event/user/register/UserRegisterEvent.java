package com.dogsong.event.user.register;

import org.springframework.context.ApplicationEvent;

/**
 * 用户注册事件监听
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/22
 */
public class UserRegisterEvent extends ApplicationEvent {

    /** 用户名 */
    private String username;

    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
