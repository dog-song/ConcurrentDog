package com.dogsong.service.impl;

import com.dogsong.dao.NotificationTaskDAO;
import com.dogsong.service.NotificationTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 通知任务记录
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/7/11
 */
@Slf4j
@Component
public class NotificationTaskServiceImpl implements NotificationTaskService {

    @Autowired
    private NotificationTaskDAO notificationTaskDAO;

    @Override
    public void save() {
        log.info("---- 保存任务记录 ----");

        notificationTaskDAO.save();
    }

}
