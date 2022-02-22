package com.dogsong.a.binarysearch;

/**
 * [53] 最大子数组和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/21
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        final int N = nums == null ? 0 : nums.length;
        // pre 表示 nums[i] 的值
        long pre = 0;
        // pre_min 表示 nums[0] ... nums[i-1] 的最小值
        // pre - pre_min 就是落差，也就是 nums[] 数组的连续子数组和
        long pre_min = 0;
        long ans = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            // pre 表示的是 nums[i] 的值
            pre += nums[i];
            ans = Math.max(ans, pre - pre_min);
            pre_min = Math.min(pre_min, pre);
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
