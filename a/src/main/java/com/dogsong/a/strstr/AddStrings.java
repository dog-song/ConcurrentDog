package com.dogsong.a.strstr;

/**
 * [415] 字符串相加
 *
 * https://leetcode-cn.com/problems/add-strings/
 *
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/21
 */
public class AddStrings {

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            // 取余
            ans.append(result % 10);
            // 取整 -- 进位
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}
