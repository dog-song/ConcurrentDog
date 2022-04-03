package com.dogsong.a.array.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * BucketSort
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/30
 */
public class BucketSort {

    public static List<Integer> sort(List<Integer> A) {
        int k = 100;

        List<LinkedList<Integer>> buckets = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            buckets.add(new LinkedList<>());
        }

        for (int item : A) {
            buckets.get(item % k).add(item);
        }

        for (LinkedList<Integer> bucket : buckets) {
            list.addAll(bucket);
        }

        return list;
    }
}
