package com.dogsong.c;

import com.beust.jcommander.internal.Lists;
import org.apache.commons.collections4.CollectionUtils;

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
        List<Map<String, String>> objects = Lists.newArrayList();
        // objects.add(new HashMap<>());

        if (CollectionUtils.isEmpty(objects) || objects.size() == 0) {
            System.out.println("000000");
        } else {
            System.out.println("111111");
        }
    }

}
