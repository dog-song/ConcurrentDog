package com.dogsong.c;

/**
 * 形参与实参
 *
 * 在 swap() 方法中:
 *  形参: numa 和 numb
 *  实参: a 和 b
 *
 *  还需要了解一下 值传递 和 引用传递
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/12/16
 */
public class FormalArguments {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;

        System.out.println("a = " + a + ", b = " + b);

        long start = System.nanoTime();

        Integer tmp = a;
        a = b;
        b = tmp;

        // swap(a, b);


        // 通过位运算
        /*a = a ^ b;
        b = a ^ b;
        a = a ^ b;*/

        long end = System.nanoTime();

        System.out.println("---------------time : " + (end - start));


        System.out.println("a = " + a + ", b = " + b);
    }

    public static void swap(Integer numa, Integer numb) {
        Integer tmp = numa;
        numa = numb;
        numb = tmp;
        System.out.println("numa=" + numa + ",numb=" + numb);
    }
}
