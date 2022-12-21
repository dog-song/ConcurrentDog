package com.dogsong.springframework.beans.factory.config;

import com.dogsong.springframework.beans.BeansException;
import com.dogsong.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * 允许自定义修改 BeanDefinition 属性信息
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/12/15
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory beanFactory
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
