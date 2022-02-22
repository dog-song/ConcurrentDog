package com.dogsong.b.thread.create;

/**
 * 实现 Runnable 接口创建线程
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/23
 */
public class ImplRunnable implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            count += 1;
            System.out.println(Thread.currentThread().getName() + "运行  count= " + count);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ImplRunnable runnable = new ImplRunnable();

        new Thread(runnable, "A").start();
        new Thread(runnable, "B").start();

    }
}
