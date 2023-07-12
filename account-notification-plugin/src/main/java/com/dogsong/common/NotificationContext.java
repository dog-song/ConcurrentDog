package com.dogsong.common;

import lombok.Data;

/**
 * 通知类组件上下文信息
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/7/11
 */
@Data
public class NotificationContext {

    private String id;

    private String topicName;

    private String requestSequence;

    private String requestDraft;



}
