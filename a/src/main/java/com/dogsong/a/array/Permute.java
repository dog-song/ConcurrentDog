package com.dogsong.a.array;

import java.util.ArrayList;
import java.util.List;

/**
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/23
 */
public class Permute {

    private void append(List<Integer> box, List<List<Integer>> ans) {
        ans.add(new ArrayList<>());
        for (Integer x : box) {
            ans.get(ans.size() - 1).add(x);
        }
    }

    private void backtrack(int[] nums, int i, boolean[] used, List<Integer> box, List<List<Integer>> ans) {
        final int N = nums == null ? 0 : nums.length;

        // 如果状态已经满足要求
        if (box.size() == N) {
            append(box, ans);
        }

        if (i >= N) {
            return;
        }

        for (int j = 0; j < N; j++) {
            if (!used[j]) {
                box.add(nums[j]);
                used[j] = true;
                backtrack(nums, i+1, used, box, ans);
                box.remove(box.size() - 1);
                used[j] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        final int N = nums == null ? 0 : nums.length;

        List<List<Integer>> ans = new ArrayList<>();
        if (N == 0) {
            return ans;
        }

        boolean[] used = new boolean[N];
        List<Integer> box = new ArrayList<>();

        backtrack(nums, 0, used, box, ans);
        return ans;
    }

}
