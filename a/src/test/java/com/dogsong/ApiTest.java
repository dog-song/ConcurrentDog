package com.dogsong;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Test
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/11/22
 */
public class ApiTest {

    @Test
    public void test_128hash() {

        // 初始化一组字符串
        List<String> list = new ArrayList<>();
        list.add("jlkk");
        list.add("lopi");
        list.add("小傅哥");
        list.add("e4we");
        list.add("alpo");
        list.add("yhjk");
        list.add("plop");

        // 定义要存放的数组
        String[] tab = new String[8];

        // 循环存放
        for (String key : list) {
            // 计算索引位置
            int idx = key.hashCode() & (tab.length - 1);
            System.out.println(String.format("key值=%s Idx=%d", key, idx));

            if (null == tab[idx]) {
                tab[idx] = key;
                continue;
            }
            tab[idx] = tab[idx] + "->" + key;
        }

        // 输出测试结果
        System.out.println("测试结果：" + JSON.toJSONString(tab));
    }

    @Test
    public void test_hashMap() {
        List<String> list = new ArrayList<>();
        list.add("jlkk");
        list.add("lopi");
        list.add("jmdw");
        list.add("e4we");
        list.add("io98");
        list.add("nmhg");
        list.add("vfg6");
        list.add("gfrt");
        list.add("alpo");
        list.add("vfbh");
        list.add("bnhj");
        list.add("zuio");
        list.add("iu8e");
        list.add("yhjk");
        list.add("plop");
        list.add("dd0p");

        for (String key : list) {
            int hash = key.hashCode() ^ (key.hashCode() >>> 16);
            System.out.println("字符串：" + key + " \tIdx(16)：" + ((16 - 1) & hash) + " \tBit值：" + Integer.toBinaryString(hash) + " - " + Integer.toBinaryString(hash & 16) + " \t\tIdx(32)：" + ((32 - 1) & hash));
            System.out.println(Integer.toBinaryString(key.hashCode()) +" "+ Integer.toBinaryString(hash) + " " + Integer.toBinaryString((32 - 1) & hash));
        }
    }

}
