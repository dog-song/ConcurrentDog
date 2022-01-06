package com.dogsong.b.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockDemo
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/1/6
 */
public class ReentrantLockDemo implements Runnable {

    public static ReentrantLock lock = new ReentrantLock(false);

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "get lock ");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();

        Thread t1 = new Thread(reentrantLockDemo);
        Thread t2 = new Thread(reentrantLockDemo);

        t1.start();
        t2.start();
    }

}
