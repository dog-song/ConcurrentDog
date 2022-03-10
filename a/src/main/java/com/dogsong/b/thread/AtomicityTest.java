package com.dogsong.b.thread;

import java.util.ArrayList;

/**
 * synchronized 保证原子性
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/10
 */
@SuppressWarnings("all")
public class AtomicityTest {

    private static int num = 0;

    private static Object object = new Object();

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (object) {
                    num ++;
                }
            }
        };

        ArrayList<Thread> as = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(runnable);
            t.start();
            as.add(t);
        }

        as.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(num);
    }

}
