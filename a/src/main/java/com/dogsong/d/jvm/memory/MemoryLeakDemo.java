package com.dogsong.d.jvm.memory;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 模拟内存泄漏样例
 * 1. 定义静态变量HashMap
 * 2. 分段循环创建对象，并加入HashMap
 *
 * 3. 设置启动参数：
      -Xms512m
      -Xmx512m
      -XX:-UseGCOverheadLimit
      -XX:MaxPermSize=50m
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/25
 */
public class MemoryLeakDemo {

    /** 声明缓存对象 */
    private static final Map map = Maps.newHashMap();


    public static void main(String[] args) {
        // 给打开 visualvm 时间
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 循环添加对象到缓存
        for (int i = 0; i < 1000000; i++) {
            TestMemory t = new TestMemory();
            map.put("key"+i, t);
        }
        System.out.println("first");

        // 为dump出堆提供时间
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000000; i++) {
            TestMemory t = new TestMemory();
            map.put("key"+i, t);
        }
        System.out.println("-----second");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3000000; i++) {
            TestMemory t = new TestMemory();
            map.put("key"+i, t);
        }
        System.out.println("third");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 4000000; i++) {
            TestMemory t = new TestMemory();
            map.put("key"+i, t);
        }
        System.out.println("-----forth");

        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("qqqq");

    }




    static class TestMemory {
        private int id;
    }

}
