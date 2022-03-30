package com.dogsong.a.array;

/**
 * BubbleSort
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/30
 */
public class BubbleSort {

    public void sort(int[] A) {
        for (int i = A.length; i >= 0; i--) {
            // 找到 0-i之间的最大元素放到A[i]
            bubble(A, 0, i+1);
        }
    }

    private void bubble(int[] A, int i, int j) {
        for (int k = 0; k < j-1; k++) {
            if (A[k] > A[k+1]) {
                swap(A, k, k+1);
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
