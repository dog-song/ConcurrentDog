package com.dogsong.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * NoticeAutoConfiguration
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/7/13
 */
@Configuration
@EnableConfigurationProperties(NotificationConfig.class)
public class NoticeAutoConfiguration {

    private final Logger logger = LoggerFactory.getLogger(NoticeAutoConfiguration.class);

    @Autowired
    private NotificationConfig notificationConfig;


    @PostConstruct
    public void init() {
        logger.info("---- 配置的 path 是: {}.", notificationConfig.getUri());
    }

}
