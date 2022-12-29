package com.dogsong.springframework.context.support;

import com.dogsong.springframework.beans.BeansException;

/**
 * ClassPathXmlApplicationContext
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/12/28
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }

}
