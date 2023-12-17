package com.dogsong.controller;

import com.dogsong.config.NotificationConfig;
import com.dogsong.listener.NoticeListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * TestController
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/7/13
 */
@RestController
@Slf4j
public class TestController {

    @Autowired
    private Environment environment;

    @Autowired
    private NoticeListener listener;

    @RequestMapping(value = "${eisp.api.uri}", name = "方法上动态参数设置", method = RequestMethod.POST)
    public String test() {
        log.info("----------");

        // listener.doTask();

        return "success";
    }

    /**
     * 动态设置类上的注解的参数值
     */
    @PostConstruct
    public void init() {
        RequestMapping mapping = this.getClass().getAnnotation(RequestMapping.class);
        // 获取参数值
        String value = environment.resolvePlaceholders(mapping.value()[0]);

        // 输出
        log.info("eisp.api.uri -------->" + value);
        mapping.consumes();
    }


}
