package com.dogsong.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * NotificationConfig
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/7/13
 */
@ConfigurationProperties("eisp.api")
public class NotificationConfig {

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    private String uri;

}
