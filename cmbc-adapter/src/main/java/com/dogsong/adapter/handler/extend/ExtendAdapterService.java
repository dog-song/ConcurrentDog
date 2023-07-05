package com.dogsong.adapter.handler.extend;

/**
 * ExtendAdapterService
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/6/30
 */
public interface ExtendAdapterService {

    String getTransCode();

    void beforeSend();

    void afterSend();

}
