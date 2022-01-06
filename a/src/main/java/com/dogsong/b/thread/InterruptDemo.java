package com.dogsong.b.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试中断
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/1/7
 */
public class InterruptDemo {

    @SuppressWarnings("all")
    public static void testSync() {
        InterruptDemo lock = new InterruptDemo();

        Thread t = new Thread(() -> {
            int k = 0;
            synchronized (lock) {
                for (int i = 0; i < 100000000; i++) {
                    k += 1;
                }
                System.out.println("finished. k:" + k);
            }
        });
        t.start();
        t.interrupt();
    }

    @SuppressWarnings("all")
    public static void testReentrantLock() {
        ReentrantLock lock = new ReentrantLock();

        Thread t = new Thread(() -> {
            int k = 0;

            try {
                lock.lockInterruptibly();
                for (int i = 0; i < 100000000; i++) {
                    k += 1;
                }
                System.out.println("finished k:" + k);
            } catch (Exception e) {
                System.out.println("interrupt k:" + k);
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            synchronized (lock) {


            }
        });
        t.start();
        t.interrupt();
    }



    public static void main(String[] args) {
        // 测试 Sync
        // testSync();

        // 测试 ReentrantLock
        testReentrantLock();
    }

}
