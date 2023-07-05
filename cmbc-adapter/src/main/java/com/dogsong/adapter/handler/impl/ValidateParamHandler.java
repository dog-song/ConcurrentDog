package com.dogsong.adapter.handler.impl;

import com.dogsong.adapter.handler.ValidateParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * ValidateParamHandler
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/6/30
 */
@Slf4j
@Service
public class ValidateParamHandler implements ValidateParam {
    @Override
    public void validatedOriginParam() {
        log.info("--------- 元数据校验 ---------");
    }
}
