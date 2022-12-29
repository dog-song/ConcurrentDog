package com.dogsong.springframework.beans.factory.support;

import com.dogsong.springframework.beans.BeansException;
import com.dogsong.springframework.core.io.Resource;
import com.dogsong.springframework.core.io.ResourceLoader;

/**
 * Simple interface for bean definition readers
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/12/1
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;
}
