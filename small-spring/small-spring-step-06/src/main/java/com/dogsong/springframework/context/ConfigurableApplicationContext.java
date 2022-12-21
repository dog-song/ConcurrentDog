package com.dogsong.springframework.context;

import com.dogsong.springframework.beans.BeansException;

/**
 * 上下文的实现中完成刷新容器的操作过程
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/12/21
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * refresh
     */
    void refresh() throws BeansException;
}
