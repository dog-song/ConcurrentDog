package com.dogsong;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

}
