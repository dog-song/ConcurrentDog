package com.dogsong.a.sort;

import java.util.Arrays;

/**
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/15
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int l = 0, i = 0;

        while (i < nums.length) {
            if (nums[i] != 0) {
                int t = nums[l];
                nums[l] = nums[i];
                nums[i] = t;

                i += 1;
                l += 1;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};

        moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }

}
