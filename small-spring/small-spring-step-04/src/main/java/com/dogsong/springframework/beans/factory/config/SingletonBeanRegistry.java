package com.dogsong.springframework.beans.factory.config;

/**
 * 单例注册表
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/11/1
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
