package com.dogsong.a.sort;

import java.util.Arrays;

/**
 * [75] 颜色分类
 *
 * https://leetcode-cn.com/problems/sort-colors/description/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/14
 */
public class SortColors {

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void sortColors(int[] nums) {
        final int N = nums.length;

        int i = 0, l = 0, r = N - 1;

        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, l++, i++);
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, r--, i);
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{2,0,2,1,1,0};

        sortColors(nums);

        System.out.println(Arrays.toString(nums));

    }
}
