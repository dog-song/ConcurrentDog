package com.dogsong.a.array;

import java.util.PriorityQueue;

/**
 * [215] 数组中的第K个最大元素
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/10
 */
public class FindKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length);

        for (int i = 0; i < k; i++) {
             queue.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++){
            if (nums[i] > queue.peek()){
                queue.poll();
                queue.add(nums[i]);
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,0,1,6,3,8};

        System.out.println(findKthLargest(nums, 2));
    }
}
