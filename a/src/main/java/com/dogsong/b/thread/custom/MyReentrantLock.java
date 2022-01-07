package com.dogsong.b.thread.custom;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义 一个可重入锁
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2022/1/7
 */
public class MyReentrantLock implements Lock {

    private boolean isLocked = false;

    // 保存当前获得锁的线程
    private Thread lockedBy = null;

    // 保存上锁次数
    private int lockedCount = 0;


    @Override
    public void lock() {
        synchronized (this) {
            Thread callingThread = Thread.currentThread();
            // 判断是否为当前线程
            while (isLocked && lockedBy != callingThread) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isLocked = true;
            lockedBy = callingThread;
            lockedCount ++;
        }
    }

    @Override
    public void unlock() {
        synchronized (this) {
            // 判断是否为当前线程
            if (Thread.currentThread() == lockedBy) {
                lockedCount --;
                if (lockedCount == 0) {
                    isLocked = false;
                    this.notify();
                }
            }
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
