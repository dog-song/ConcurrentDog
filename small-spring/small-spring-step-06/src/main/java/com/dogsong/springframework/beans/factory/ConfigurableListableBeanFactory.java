package com.dogsong.springframework.beans.factory;

import com.dogsong.springframework.beans.BeansException;
import com.dogsong.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.dogsong.springframework.beans.factory.config.BeanDefinition;
import com.dogsong.springframework.beans.factory.config.BeanPostProcessor;
import com.dogsong.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 * <p/>
 * 大多数可列出的 Bean 工厂要实现的配置接口。除了 {@link ConfigurableBeanFactory} 之外，
 * 它还提供了分析和修改 Bean 定义以及预实例化单例的工具。
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/12/15
 */
public interface ConfigurableListableBeanFactory extends
        ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
