package com.dogsong.b.threadpool;

/**
 * TODO
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/1/18
 */
public class ThreadDemo extends Thread {

    private String name;

    public ThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }


    public static void main(String[] args) {
        new ThreadDemo("aaa").run();

        new ThreadDemo("bbb").start();
    }
}
