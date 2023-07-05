package com.dogsong.service.impl;

import freemarker.template.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * FreemarkerServiceImpl
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/5/30
 */
@Slf4j
@Service
public class FreemarkerServiceImpl {

    @Autowired
    @Qualifier("getFreeMarkerConfiguration")
    private Configuration freemarkerConfigDB;


}
