package com.dogsong.springframework.context.support;

import com.dogsong.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.dogsong.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * AbstractXmlApplicationContext
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/12/28
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}
