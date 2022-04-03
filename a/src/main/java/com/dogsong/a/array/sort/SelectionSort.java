package com.dogsong.a.array.sort;

/**
 * SelectionSort 不稳定
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/30
 */
public class SelectionSort {

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

   private static int maxIndex(int[] A, int i, int j) {
        int max = Integer.MIN_VALUE;
        int maxIndex = i;

        for (int k = 0; k < j; k++) {
           if (max < A[k]) {
               max = A[k];
               maxIndex = k;
           }
        }
        return maxIndex;
   }

   public static void sort(int[] A) {
       for (int i = A.length - 1; i >= 0; i--) {
           int j = maxIndex(A, 0, i+1);
           swap(A, i, j);
       }
   }
}
