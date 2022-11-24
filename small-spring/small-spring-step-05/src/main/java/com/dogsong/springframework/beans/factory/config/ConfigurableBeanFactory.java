package com.dogsong.springframework.beans.factory.config;

/**
 * ConfigurableBeanFactory
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/11/24
 */
public interface ConfigurableBeanFactory extends SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

}
