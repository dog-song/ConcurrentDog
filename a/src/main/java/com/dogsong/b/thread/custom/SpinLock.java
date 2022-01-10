package com.dogsong.b.thread.custom;


/**
 * 自定义自旋锁
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/1/9
 */
public class SpinLock {

    // 状态 是否加锁
    private volatile int status = 0;

    public void lock() {
        while (!compareAndSet(0, 1)) {

            // yield() 当前让出 CPU, 但有可能操作系统下次还是选择运行该线程
            // yield();

        }
        // lock
    }

    public void unlock() {
        status = 0;
    }

    private boolean compareAndSet(int except, int newValue) {
        // cas 操作, 修改 status 成功则会返回 true
        return true;
    }
}
