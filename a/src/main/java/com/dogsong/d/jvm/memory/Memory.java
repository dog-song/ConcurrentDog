package com.dogsong.d.jvm.memory;

/**
 * 当前运行时内存大小
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/9
 */
public class Memory {

    public static void main(String[] args) {
        System.out.println(String.format("totalMemory = %s M", Runtime.getRuntime().totalMemory() /1024.0/1024.0));
        System.out.println(String.format("freeMemory = %s M", Runtime.getRuntime().freeMemory() /1024.0/1024.0));
        System.out.println(String.format("maxMemory = %s M", Runtime.getRuntime().maxMemory() /1024.0/1024.0));
    }

}
