package com.dogsong.adapter.handler.extend.impl;

import com.dogsong.adapter.handler.extend.ExtendAdapterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Extend503108AdapterService
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/6/30
 */
@Slf4j
@Component("503108")
public class Extend503108AdapterService implements ExtendAdapterService {

    @Override
    public String getTransCode() {
        return "503108";
    }

    @Override
    public void beforeSend() {
        log.info("----503108----beforeSend----");
    }

    @Override
    public void afterSend() {
        log.info("----503108----afterSend----");
    }
}
