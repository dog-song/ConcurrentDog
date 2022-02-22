package com.dogsong.a.binarysearch;

/**
 * 二分查找
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/22
 */
public class BinarySearch {

    public static boolean binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;

        int l = 0, r = nums.length;
        while (l < r) {
            // 取中间的值
            final int m = l + ((r - l) >> 1);

            if (target == nums[m])
                return true;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1 ,2, 3, 5, 5, 7, 8, 9};
        System.out.println(binarySearch(nums, 7));
    }

}
