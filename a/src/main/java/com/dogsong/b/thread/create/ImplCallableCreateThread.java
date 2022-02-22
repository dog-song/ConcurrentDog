package com.dogsong.b.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现 Callable 接口创建线程
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/22
 */
public class ImplCallableCreateThread implements Callable<Integer> {

    private int num = 0;

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            num ++;
        }
        return num;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new ImplCallableCreateThread();

        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        Thread thread = new Thread(futureTask);

        thread.start();

        System.out.println(futureTask.get());
    }
}
