package com.dogsong.a.array;

import java.util.Arrays;

/**
 * InsertionSort 稳定
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/30
 */
public class InsertionSort {

    public static void sort(int[] A) {
        for (int i = 0; i < A.length; i++) {

            int c = A[i];
            int j = i;

            for (; j > 0 && A[j-1] > c; j--) {
                A[j] = A[j-1];
            }
            A[j] = c;
        }
    }

    public static void main(String[] args) {
        int[] nums = {6,5,4,3,2,1};

        sort(nums);

        System.out.println(Arrays.toString(nums));
    }

}
