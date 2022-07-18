package com.dogsong.d.util;

import com.beust.jcommander.internal.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;

/**
 * TODO
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/7/14
 */
public class EqualsCountUtils {

    private static <O, E> boolean notEqualsListCount(Collection<O> list1, Collection<E> list2) {
        return CollectionUtils.size(list1) == CollectionUtils.size(list2);
    }

    public static void main(String[] args) {
        List<Integer> list1 = Lists.newArrayList();
        List<String> list2 = Lists.newArrayList();

        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add("1");
        list2.add("2");
        list2.add("3");

        System.out.println(notEqualsListCount(list1, list2));
    }

}
