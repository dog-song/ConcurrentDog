package com.dogsong.b.thread.create;

/**
 * 继承 Thread 创建线程
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/22
 */
public class ExtendThread extends Thread {

    private int count = 0;

    private String name;

    public ExtendThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            count += 1;
            System.out.println(name + "运行  count= " + count);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExtendThread t1 = new ExtendThread("A");
        ExtendThread t2 = new ExtendThread("B");

        t1.start(); t2.start();
    }

}
