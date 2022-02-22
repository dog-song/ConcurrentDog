package com.dogsong.a.binarysearch;

import com.dogsong.a.helper.SortHelper;
import com.dogsong.a.sort.QuickSort;

import java.util.Arrays;

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
        // 获取随机数组
        int[] nums = SortHelper.randomArray(10);
        System.out.println(Arrays.toString(nums));

        // 先排序
        QuickSort.quickSort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(SortHelper.validate(nums));

        System.out.println(binarySearch(nums, 7));
    }

}
