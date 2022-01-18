package com.dogsong.b.thread;

/**
 * 线程安全例子
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/1/13
 */
public class ThreadSafeSample {

    public int sharedState;

    public void nonSafeAction() {
        while (sharedState < 100000) {

            synchronized (this) {
                int former = sharedState++;
                int latter = sharedState;
                if (former != latter - 1) {
                    System.out.printf("Observed data race, former is " + former + ", " + "latter is " + latter);
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeSample sample = new ThreadSafeSample();
        Thread threadA = new Thread(){
            public void run(){
                sample.nonSafeAction();
            }
        };
        Thread threadB = new Thread(){
            public void run(){
                sample.nonSafeAction();
            }
        };

        threadA.start();
        threadB.start();
        // join() 是等待这个线程死掉
        threadA.join();
        threadB.join();

    }
}
