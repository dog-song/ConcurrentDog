package com.dogsong.adapter.handler.impl;

import com.dogsong.adapter.handler.ConversionParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * ConversionParamHandler
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/6/30
 */
@Slf4j
@Service
public class ConversionParamHandler implements ConversionParam {
    @Override
    public void transCodeConversion() {
        log.info("--------- 交易码转换 ---------");
    }
}
