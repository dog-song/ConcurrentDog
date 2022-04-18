package com.dogsong.b.hashmap;


import java.util.HashMap;
import java.util.Map;

/**
 * demo 使用
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/14
 */
public class Demo {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        String put = map.put("zhangsan", "zhangsan");
        System.out.println(put);


        String put1 = map.put("zhangsan", "lisi");
        System.out.println(put1);
    }

}
