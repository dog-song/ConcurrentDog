package com.dogsong;

import org.junit.Test;

/**
 * IntTest
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2023/4/7
 */
public class IntTest {

    @Test
    public void test_128hash() {
        Integer a1 = 127;
        Integer b1 = 127;
        System.out.println(a1 == b1);

        Integer a2 = new Integer(127);
        Integer b2 = new Integer(127);
        System.out.println(a2 == b2);

        Integer a3 = 128;
        Integer b3 = 128;
        System.out.println(a3 == b3);
        System.out.println(System.identityHashCode(a3));
        System.out.println(System.identityHashCode(b3));

        // [-128, +127]
        // [-127, +127]

        // +0, -0
        // 1111 1111 原码:
        // 源码
        Integer.valueOf(11);

    }

}
