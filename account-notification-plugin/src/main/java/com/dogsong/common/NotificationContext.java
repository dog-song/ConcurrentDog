package com.dogsong.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通知类组件上下文信息
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/7/11
 */
@Data
public class NotificationContext implements Serializable {

    private String id;

    private String topicName;

    private String requestSequence;

    private String requestDraft;

    // TODO: 2023/7/12 需要使用 eda 的实体


}
