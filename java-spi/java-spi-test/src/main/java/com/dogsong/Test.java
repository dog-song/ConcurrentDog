package com.dogsong;

import com.dogsong.util.RequestUtil;

/**
 * Test
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/19
 */
public class Test {

    public static void main(String[] args) {
        RequestUtil.getInstance().sendRequest("hello!");
    }

}
