package com.dogsong.c;

import com.beust.jcommander.internal.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/12/17
 */
public class Test {

    public static void main(String[] args) {
        // List<Map<String, String>> objects = Lists.newArrayList();
        // // objects.add(new HashMap<>());
        //
        // if (CollectionUtils.isEmpty(objects) || objects.size() == 0) {
        //     System.out.println("000000");
        // } else {
        //     System.out.println("111111");
        // }

        test1();
    }


    public static void test1() {
        List<Map<String, String>> mapList = new ArrayList<>();

        Map<String, String> map1 = new HashMap<>();
        map1.put("111", "111");
        mapList.add(map1);

        Map<String, String> map2 = new HashMap<>();
        map2.put("111", "222");
        mapList.add(map2);

        Map<String, String> map3 = new HashMap<>();
        map3.put("111", "333");
        mapList.add(map3);

        mapList.forEach(Test::replaceDict);

        System.out.println(mapList.toString());

    }

    public static void replaceDict(Map<String, String> map) {
        map.put("111", "domi");
    }

    public static void test2() {

    }

}
