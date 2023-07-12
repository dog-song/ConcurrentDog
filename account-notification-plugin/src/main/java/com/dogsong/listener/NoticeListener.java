package com.dogsong.listener;

import com.dogsong.notice.NoticeHandler;
import com.dogsong.service.NotificationTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private NotificationTaskService notificationTaskService;

    @Autowired
    private NoticeHandler noticeHandler;

    public void doTask() {
        log.info("---- listener ----");

        notificationTaskService.save();
        log.info("---- save job ----");

        noticeHandler.execute();
        log.info("---- execute job ----");
    }

}
