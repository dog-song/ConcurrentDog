package com.dogsong.springframework.context.support;

import com.dogsong.springframework.beans.BeansException;
import com.dogsong.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.dogsong.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.dogsong.springframework.beans.factory.config.BeanPostProcessor;
import com.dogsong.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.dogsong.springframework.context.ConfigurableApplicationContext;
import com.dogsong.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * 抽象应用上下文
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/12/21
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {


    @Override
    public void refresh() throws BeansException {
        // 1. 创建 BeanFactory, 并加载 BeanDefinition
        refreshBeanFactory();

        // 2. 获取 beanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3. 在 bean 实例化之前, 执行 BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessor(beanFactory);

        // 4. BeanPostProcessor 需要提前于其他 bean 对象之前执行注册操作
        registerBeanPostProcessor(beanFactory);

        // 5. 提前实例化 bean 对象
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    /**
     * 在 bean 实例化之前, 执行 BeanFactoryPostProcessor
     *
     * @param beanFactory ConfigurableListableBeanFactory
     */
    private void invokeBeanFactoryPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    /**
     * BeanPostProcessor 需要提前于其他 bean 对象之前执行注册操作
     *
     * @param beanFactory ConfigurableListableBeanFactory
     */
    private void registerBeanPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }

    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    /**
     * 按照类型返回 Bean 实例
     *
     * @param type
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    /**
     * Return the names of all beans defined in this registry.
     * 返回注册表中所有的Bean名称
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }
}
