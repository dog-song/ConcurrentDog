package com.dogsong.b.thread.custom;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义一把简单的锁
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2022/1/7
 */
public class MyLock implements Lock {

    private boolean isLocked = false;

    @Override
    public void lock() {
        synchronized (this) {
            while (isLocked) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isLocked = true;
        }
    }

    @Override
    public void unlock() {
        synchronized (this) {
            isLocked = false;
            this.notify();
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
