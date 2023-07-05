package com.dogsong.adapter.handler.impl;

import com.dogsong.adapter.handler.AbstractBuildDataModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * BuildDataModelHandler
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/6/29
 */
@Slf4j
@Service
public class BuildDataModelHandler extends AbstractBuildDataModel {


    @Override
    protected void beforeSend() {
        log.info("--------- 封装数据模型 before---------");
    }

    @Override
    protected void afterSend() {
        log.info("--------- 封装数据模型 after---------");
    }
}
