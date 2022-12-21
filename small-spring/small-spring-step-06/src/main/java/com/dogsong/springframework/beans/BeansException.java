package com.dogsong.springframework.beans;

/**
 * BeansException
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/10/31
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
