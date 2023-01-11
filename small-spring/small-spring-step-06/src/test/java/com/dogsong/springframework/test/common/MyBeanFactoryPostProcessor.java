package com.dogsong.springframework.test.common;

import com.dogsong.springframework.beans.BeansException;
import com.dogsong.springframework.beans.PropertyValue;
import com.dogsong.springframework.beans.PropertyValues;
import com.dogsong.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.dogsong.springframework.beans.factory.config.BeanDefinition;
import com.dogsong.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * MyBeanFactoryPostProcessor
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/1/10
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory beanFactory
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "modify: cmbc"));
    }
}
