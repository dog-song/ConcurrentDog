package com.dogsong.b.thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 自定义同步器 Mutex
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/1/7
 */
public class Mutex {

    private final Sync sync = new Sync();

    static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int arg) {
            return compareAndSetState(1, 0);
        }
    }

    public void lock() {
        sync.tryAcquire(0);
    }

    public void unlock() {
        sync.release(0);
    }
}
