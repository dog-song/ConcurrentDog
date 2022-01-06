package com.dogsong.b.integer;

/**
 * integer demo
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2022/1/6
 */
public class IntegerDemo {

    public static void main(String[] args) {
        Integer i = 1;

        // identityHashCode() 方法可以理解为输出对应变量的内存地址
        System.out.println("i: " + i + " " + System.identityHashCode(i));
    }

}
