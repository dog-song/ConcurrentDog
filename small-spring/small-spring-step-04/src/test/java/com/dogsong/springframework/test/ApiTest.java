package com.dogsong.springframework.test;

import com.dogsong.springframework.beans.PropertyValue;
import com.dogsong.springframework.beans.PropertyValues;
import com.dogsong.springframework.beans.factory.config.BeanDefinition;
import com.dogsong.springframework.beans.factory.config.BeanReference;
import com.dogsong.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.dogsong.springframework.test.bean.UserDao;
import com.dogsong.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * ApiTest
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/11/20
 */
public class ApiTest {

    @Test
    public void testBeanFactory() {
        // 1. init bean-factory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10003"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");

        userService.queryUserInfo();
    }
}
