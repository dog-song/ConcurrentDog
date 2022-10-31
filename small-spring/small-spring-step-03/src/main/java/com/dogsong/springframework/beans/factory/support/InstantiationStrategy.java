package com.dogsong.springframework.beans.factory.support;

import com.dogsong.springframework.beans.BeansException;

/**
 * Bean 实例化策略
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/11/1
 */
public interface InstantiationStrategy {

    Object instantiation() throws BeansException;
}
