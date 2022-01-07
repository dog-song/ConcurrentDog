package com.dogsong.b.thread.custom;

import java.util.concurrent.locks.Lock;

/**
 * test
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2022/1/7
 */
public class MyLockTest {

    /**
     * 通过 synchronized 实现的锁
     */
    @SuppressWarnings("all")
    public static class MySyncClass implements Runnable {

        private boolean available;

        public synchronized void kill() {
            String name = Thread.currentThread().getName();
            if (available) {
                System.out.println(name + " 获取失败...");
                return;
            }
            available = true;
            System.out.println(name + " 获取成功! ");
        }

        @Override
        public void run() {
            this.kill();
        }
    }

    /**
     * 通过 自定义锁{@link MyLock} 实现
     */
    @SuppressWarnings("all")
    public static class MyLockClass implements Runnable {

        private boolean available;

        // 创建锁对象
        private Lock lock = new MyLock();

        public void kill() {
            try {
                // 获取锁
                lock.lock();
                String name = Thread.currentThread().getName();
                if (available) {
                    System.out.println(name + " 获取失败...");
                    return;
                }
                available = true;
                System.out.println(name + " 获取成功! ");
            } finally {
                // 执行结束之后, 释放锁
                lock.unlock();
            }
        }

        @Override
        public void run() {
            kill();
        }
    }

    /**
     * 通过 自定义锁{@link MyReentrantLock} 实现可重入锁
     */
    @SuppressWarnings("all")
    public static class MyReentrantClass implements Runnable {

        private boolean available;

        // 创建锁对象
        private Lock lock = new MyReentrantLock();

        public synchronized void methodB() {
            try {
                // 获取锁
                lock.lock();
                String name = Thread.currentThread().getName();
                if (available) {
                    System.out.println(name + " 获取失败...");
                    return;
                }
                available = true;
                System.out.println(name + " 获取成功! ");
            } finally {
                // 执行结束之后, 释放锁
                lock.unlock();
            }
        }

        public synchronized void methodA() {
            methodB();
        }

        @Override
        public void run() {
            methodA();
        }
    }

    public static void main(String[] args) {
        /*MySyncClass mySyncLock = new MySyncClass();

        Thread t1 = new Thread(mySyncLock, "t1");
        Thread t2 = new Thread(mySyncLock, "t2");

        t1.start();
        t2.start();*/


        /*MyLockClass myLockClass = new MyLockClass();

        Thread t3 = new Thread(myLockClass, "t3");
        Thread t4 = new Thread(myLockClass, "t4");

        t3.start();
        t4.start();*/

        MyReentrantClass myReentrantClass = new MyReentrantClass();

        Thread t5 = new Thread(myReentrantClass, "t5");
        Thread t6 = new Thread(myReentrantClass, "t6");

        t5.start();
        t6.start();
    }
}
