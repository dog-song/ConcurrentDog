package com.dogsong.springframework.beans.factory.support;

/**
 * BeanDefinitionRegistry
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/11/1
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     */
    void registerBeanDefinition();

}
