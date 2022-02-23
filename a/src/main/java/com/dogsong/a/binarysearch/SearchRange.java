package com.dogsong.a.binarysearch;

import com.dogsong.a.helper.SortHelper;
import com.dogsong.a.sort.QuickSort;

import java.util.Arrays;

/**
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/23
 */
public class SearchRange {

    public static int lowerBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            final int m = l + ((r - l) >> 1);
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static int upperBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length;

        while (l < r) {
            final int m = l + ((r - l) >> 1);
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums == null || nums.length == 0) return ans;

        int l = lowerBound(nums, target);
        int r = upperBound(nums, target);

        if (l == r) return ans;

        ans[0] = l;
        ans[1] = r - 1;

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = SortHelper.randomArray(10);
        QuickSort.quickSort(nums);

        System.out.println(Arrays.toString(nums));

        int[] ans = searchRange(nums, 8);

        System.out.println(Arrays.toString(ans));

    }

}
