package com.dogsong.adapter.handler.impl;

import com.dogsong.adapter.handler.MappingParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * MappingParamHandler
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/6/30
 */
@Slf4j
@Service
public class MappingParamHandler implements MappingParam {
    @Override
    public void doMapping() {
        log.info("--------- 参数映射 ---------");
    }
}
