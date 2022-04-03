package com.dogsong.a.array.sort;

import java.util.List;
import java.util.stream.Collectors;

/**
 * QuickSort
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/30
 */
public class QuickSort {

    private static List<Integer> quickSort(List<Integer> A) {
        if (A.size() <= 1) {
            return A;
        }

        // |---left---| x |---right---||
        Integer x = A.get(0);
        List<Integer> left = A.stream().filter(a -> a < x).collect(Collectors.toList());
        List<Integer> mid = A.stream().filter(a -> a == x).collect(Collectors.toList());
        List<Integer> right = A.stream().filter(a -> a > x).collect(Collectors.toList());

        left = quickSort(left);
        right = quickSort(right);

        left.addAll(mid);
        left.addAll(right);

        return left;
    }

    public static List<Integer> sort(List<Integer> A) {
        return quickSort(A);
    }

}
