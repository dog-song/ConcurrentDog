package com.dogsong.a.array;

/**
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/10
 */
public class MergeTwoArray {

    public static void mergeTwoLists(int[] nums1, int m, int[] nums2, int n) {
        int tail = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 || j >= 0) {
            if (j < 0 || (i >= 0 && nums1[i] >= nums2[j])) {
                nums1[tail--] = nums1[i--];
            } else {
                nums1[tail--] = nums2[j--];
            }
        }
    }

}
