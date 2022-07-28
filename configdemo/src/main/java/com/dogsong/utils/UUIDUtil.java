package com.dogsong.utils;

import java.util.UUID;

/**
 * UUIDUtil
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/25
 */
public class UUIDUtil {

    public static String build() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }

}
