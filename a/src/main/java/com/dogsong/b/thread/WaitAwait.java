package com.dogsong.b.thread;

/**
 * wait
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/1/7
 */
public class WaitAwait {

    @SuppressWarnings("all")
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

        Thread t1 = new Thread(() -> {
            System.out.println("before-wait...1");

            // wait
            try {
                synchronized (obj) {
                    obj.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("after-wait...1");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("before-wait...2");

            // wait
            try {
                synchronized (obj) {
                    obj.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("after-wait...2");
        });

        t1.start();
        t2.start();


        Thread.sleep(1);
        // notify
        synchronized (obj) {
            obj.notifyAll();
        }
    }
}
