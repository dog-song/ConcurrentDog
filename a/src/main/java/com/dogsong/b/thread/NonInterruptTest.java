package com.dogsong.b.thread;

/**
 * synchronized 不可中断
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/10
 */

public class NonInterruptTest {

    private static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable run = () -> {
            synchronized (obj) { //在Runnable定义同步代码块
                String name = Thread.currentThread().getName();
                System.out.println(name + "进入同步代码块");
                try {  // 保证不退出同步代码块
                    Thread.sleep(888888);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(run);  // 开启一个线程来执行同步代码块
        t1.start();
        Thread.sleep(1000);//主线程
        Thread t2 = new Thread(run);  //后开启一个线程来执行同步代码块(阻塞状态)
        t2.start();//没有锁阻塞
        System.out.println("停止线程前");  // 停止第二个线程
        t2.interrupt();//中断线程
        System.out.println("停止线程后");
        System.out.println(t1.getState()); //执行的是sleep，处于TIMED_WAITING
        System.out.println(t2.getState());
    }
}
