package com.dogsong.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * NoticeListener
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/7/11
 */
@Slf4j
@Component
public class NoticeListener {

    public void doTask() {
        log.info("---- listener ----");
    }

}
