package com.dogsong.a.array.sort;

import java.util.Arrays;

/**
 * MergeSort
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/30
 */
public class MergeSort {

    private static void merge(int[] A, int l, int mid, int r) {
        int[] B = Arrays.copyOfRange(A, l, mid+1);
        int[] C = Arrays.copyOfRange(A, mid, r+1);

        // 哨兵
        B[B.length - 1] = C[C.length - 1] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for (int k = l; k < r; k++) {
            if (B[i] < C[j]) {
                A[k] = B[i++];
            } else {
                A[k] = C[j++];
            }
        }
    }

    private static void mergeSort(int[] A, int l, int r) {
        if (r -l <= 1) {
            return;
        }

        int mid = (l + r + 1) >> 1;
        mergeSort(A, l, mid);
        mergeSort(A, mid, r);

        merge(A, l, mid, r);
    }

    public static void sort(int[] A) {
        mergeSort(A, 0, A.length);
    }

    public static void main(String[] args) {
        int[] nums = {6,5,4,3,2,1};

        sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
