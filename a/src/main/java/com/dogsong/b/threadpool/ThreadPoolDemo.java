package com.dogsong.b.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 各种线程的运行情况
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/1/18
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newFixedThreadPool(100);
        ExecutorService executorService3 = Executors.newSingleThreadExecutor();

        for (int i = 0; i <= 100; i++) {
            executorService1.execute(new MyTask(i));
        }
    }
}

class MyTask implements Runnable {

    int i = 0;

    public MyTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "---" + i);
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
