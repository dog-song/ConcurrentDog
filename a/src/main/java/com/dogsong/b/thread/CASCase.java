package com.dogsong.b.thread;

/**
 * CAS case
 * 使用 javac com/dogsong/b/thread/CASCase.java  编译一下
 * javap -verbose com/dogsong/b/thread/CASCase.class 查看
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/1/5
 */
public class CASCase {

    private volatile int value;

    public synchronized void add() {
        value++;
    }

}
