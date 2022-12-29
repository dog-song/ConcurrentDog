package com.dogsong.springframework.context.support;

import com.dogsong.springframework.beans.BeansException;
import com.dogsong.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.dogsong.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * 抽象可刷新应用程序上下文
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/12/28
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {


    private DefaultListableBeanFactory beanFactory;


    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);
}
