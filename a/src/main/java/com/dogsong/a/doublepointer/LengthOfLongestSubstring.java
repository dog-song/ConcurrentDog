package com.dogsong.a.doublepointer;

import java.util.Arrays;

/**
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/9
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        final int N = s == null ? 0 : s.length();

        int[] pos = new int[256];

        Arrays.fill(pos, -1);

        int ans = 0;

        int left = -1;

        for (int i = 0; i < N; i++) {
             final int idx = s.charAt(i);

             while (pos[idx] > left) {
                 left = pos[idx];
             }

             pos[idx] = i;

             ans = Math.max(ans, i - left);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdaaa"));
    }
}
