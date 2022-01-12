package com.dogsong.b.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * park、unpark 方法 Demo
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2022/1/12
 */
public class ParkDemo {

    @SuppressWarnings("all")
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("t1 --- run");

                // 阻塞当前线程
                LockSupport.park();
            }
        };

        t1.start();

        Thread.sleep(1000);

        // 如果要线程间通讯的话, 需要用 unpark() 并且传入当前对象 t1
        LockSupport.unpark(t1);
    }
}
