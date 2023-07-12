package com.dogsong.notice;

import lombok.extern.slf4j.Slf4j;

/**
 * AbstractNoticeHandler
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/7/12
 */
@Slf4j
public abstract class AbstractNoticeHandler implements NoticeHandler {


    @Override
    public void execute() {
        beforeHandler();

        doExecute();

        afterHandler();
    }

    public abstract void doExecute();

    public void beforeHandler() {
        log.info("---- 前置处理 ----");
        log.info("---- 更新任务处理记录 ----");
    }

    public void afterHandler() {
        log.info("---- 后置处理 ----");
        log.info("---- 更新任务处理记录 ----");
    }
}
