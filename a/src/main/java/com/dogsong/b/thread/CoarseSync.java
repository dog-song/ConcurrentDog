package com.dogsong.b.thread;

/**
 * 锁粗化
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/1/4
 */
public class CoarseSync {

    public static String copyString100Times(String target) {
        int i = 0;

        StringBuffer sb = new StringBuffer();
        while (i < 100) {
            sb.append(target);
        }

        return sb.toString();
    }

}
