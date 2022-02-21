package com.dogsong.a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * [1] 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/21
 */
public class TwoSum {

    /**
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(N^2)
     */
    public static int[] twoSum2(int[] nums, int target) {
        final int N = nums.length;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                 if (nums[i] + nums[j] == target) {
                     return new int[]{nums[i], nums[j]};
                 }
            }
        }
        return new int[0];
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {1,8,11,15};

        nums = twoSum(nums, 9);

        System.out.println(Arrays.toString(nums));
    }

}
