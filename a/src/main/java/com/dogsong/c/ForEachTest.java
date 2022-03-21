package com.dogsong.c;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/16
 */
public class ForEachTest {

    public static void main(String[] args) {
        int id = 0;
        List<ForTest> forTestList = Lists.newArrayList();
        forTestList.add(new ForTest());
        forTestList.add(new ForTest());
        forTestList.add(new ForTest());
        for (ForTest forTest : forTestList) {
            forTest.setId(id);
            id++;
        }

        forTestList.forEach(System.out::println);

        forTestList.forEach(forTest -> {
            forTest.setName("domi");
            forTest.setAge(18);
        });

        forTestList.forEach(System.out::println);

        Map<Integer, ForTest> collect = forTestList.stream().collect(Collectors.toMap(ForTest::getId, forTest -> forTest));


        System.out.println(collect);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class ForTest {
        private String name;
        private int age;
        private int id;
    }
}
