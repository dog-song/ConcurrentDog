package com.dogsong.springframework.test;

import com.dogsong.springframework.beans.factory.config.BeanDefinition;
import com.dogsong.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.dogsong.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * ApiTest
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/11/11
 */
public class ApiTest {


    @Test
    public void testBeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 3. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 4.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "dogsong");
        userService.queryUserInfo();
    }

}
