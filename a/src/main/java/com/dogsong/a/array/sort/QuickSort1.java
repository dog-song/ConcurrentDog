package com.dogsong.a.array.sort;

import java.util.Arrays;

/**
 * QuickSort1
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/30
 */
public class QuickSort1 {

    private static void swap(int[] A, int l, int r) {
        int temp = A[l];
        A[l] = A[r];
        A[r] = temp;
    }

    private static int partition(int[] A, int l, int r) {
        int x = A[l];

        int i = l + 1;
        int j = r;

        // x|b--left---|---mid---|---right--a|
        while (i != j) {
            if (A[i] < x) {
                i++;
            } else {
                swap(A, i, --j);
            }
        }

        swap(A, i-1, l);
        return i-1;
    }

    private static void quickSort(int[] A, int l, int r) {
        if (r - l <= 1) {
            return;
        }

        int i = partition(A, l ,r);

        quickSort(A, l, i);
        quickSort(A, i+1, r);
    }

    public static void sort(int[] A) {
        quickSort(A, 0, A.length);
    }


    public static void main(String[] args) {
        int[] nums = {6,5,4,3,2,1};

        sort(nums);

        System.out.println(Arrays.toString(nums));
    }
}
