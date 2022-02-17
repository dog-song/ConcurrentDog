package com.dogsong.c;

import java.util.ArrayList;
import java.util.List;

/**
 * demo
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/16
 */
public class Demo {

    public static List<Demo2> builderList() {
        List<Demo2> testList = new ArrayList<>(7);
        Demo2 t1 = new Demo2("1", "1", Boolean.TRUE);
        Demo2 t2 = new Demo2("2", "2", Boolean.FALSE);
        Demo2 t3 = new Demo2("3", "3", Boolean.TRUE);
        Demo2 t4 = new Demo2("4", "4", Boolean.FALSE);
        Demo2 t5 = new Demo2("5", "5", Boolean.TRUE);
        Demo2 t6 = new Demo2("6", "6", Boolean.FALSE);
        Demo2 t7 = new Demo2("7", "7", Boolean.FALSE);

        testList.add(t1);
        testList.add(t2);
        testList.add(t3);
        testList.add(t4);
        testList.add(t5);
        testList.add(t6);
        testList.add(t7);

        return testList;
    }


    public static void main(String[] args) {
        List<Demo2> testList = builderList();
        List<Demo2> ansList = new ArrayList<>(7);

        for (Demo2 test : testList) {
            if (Boolean.TRUE.equals(test.getBoo())) {
                ansList.add(test);
            }
        }

        System.out.println(ansList);

    }

}
