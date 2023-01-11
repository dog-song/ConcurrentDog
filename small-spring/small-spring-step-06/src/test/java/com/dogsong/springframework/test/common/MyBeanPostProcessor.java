package com.dogsong.springframework.test.common;

import com.dogsong.springframework.beans.BeansException;
import com.dogsong.springframework.beans.factory.config.BeanPostProcessor;
import com.dogsong.springframework.test.bean.UserService;

/**
 * MyBeanPostProcessor
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/1/10
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean bean
     * @param beanName name
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean bean
     * @param beanName name
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
