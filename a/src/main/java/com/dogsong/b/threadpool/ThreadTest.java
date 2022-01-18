package com.dogsong.b.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * TODO
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/1/18
 */
public class ThreadTest {


    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread() {

                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            };
            thread.start();
            thread.join();
        }

        System.out.println("时间: " + (System.currentTimeMillis() - start));
        System.out.println("大小: " + list.size());

    }
}
