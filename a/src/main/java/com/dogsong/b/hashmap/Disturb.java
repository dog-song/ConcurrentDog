package com.dogsong.b.hashmap;

/**
 * 扰乱函数
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/11/22
 */
public class Disturb {

    public static int disturbHashIdx(String key, int size) {
        return (size - 1) & (key.hashCode() ^ (key.hashCode() >>> 16));
    }

    public static int hashIdx(String key, int size) {
        return (size - 1) & key.hashCode();
    }

}
