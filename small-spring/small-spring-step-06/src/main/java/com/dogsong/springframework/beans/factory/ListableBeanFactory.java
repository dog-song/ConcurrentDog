package com.dogsong.springframework.beans.factory;

import com.dogsong.springframework.beans.BeansException;

import java.util.Map;

/**
 * 由 Bean 工厂实现的 {@link BeanFactory} 接口的扩展，
 * 该 Bean 工厂可以枚举其所有 Bean 实例，而不是按照客户端的请求尝试按名称逐个查找 Bean。
 * 预加载所有 Bean 定义的 BeanFactory 实现（例如基于 XML 的工厂）可以实现此接口
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/12/15
 */
public interface ListableBeanFactory extends BeanFactory {

     /**
      * 按照类型返回 Bean 实例
      *
      */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     * 返回注册表中所有的Bean名称
     *
     */
    String[] getBeanDefinitionNames();

}
