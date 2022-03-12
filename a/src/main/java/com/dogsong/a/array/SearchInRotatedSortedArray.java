package com.dogsong.a.array;

/**
 * [33] 搜索旋转排序数组
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/12
 */
public class SearchInRotatedSortedArray {

    public static int searchInRotatedSortedArray(int[] nums, int target) {
        final int N = nums == null ? 0 : nums.length;
        int l = 0;
        int r = N;

        while (l < r) {
            final int m = l + ((r - l) >> 1);
            if (nums[m] == target) return m;
            if (nums[l] == target) return l;
            if (nums[r - 1] == target) return r - 1;

            if (nums[m] > nums[l]) {
                if (nums[l] < target && target < nums[m]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] < target && target < nums[r - 1]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
        }

        return -1;
    }

}
