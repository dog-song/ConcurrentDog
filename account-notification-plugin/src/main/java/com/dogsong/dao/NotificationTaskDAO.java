package com.dogsong.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * 通知任务记录DAO
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/7/11
 */
@Slf4j
@Repository
public class NotificationTaskDAO {

    public void save() {
        log.info("---- 保存任务记录 ----");
    }

    public void update() {
        log.info("---- 更新任务记录 ----");
    }
}
