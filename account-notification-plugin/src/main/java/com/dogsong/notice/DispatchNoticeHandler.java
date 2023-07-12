package com.dogsong.notice;

import com.dogsong.handler.HandlerRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * DispatchNoticeHandler
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/7/12
 */
@Slf4j
@Component
public class DispatchNoticeHandler extends AbstractNoticeHandler {

    @Autowired
    private HandlerRegistry registry;

    @Override
    public void doExecute() {

        log.info("---- do something ----");

        if (!registry.containsKey("505100")) {
            log.error("---- no handler ----");
            return;
        }

        log.info("---- do handler ----");
        // 异常信息的统计
        registry.getHandler("505100").handler();
    }

}
