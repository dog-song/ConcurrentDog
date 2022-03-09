package com.dogsong.a.stack;

import java.util.Stack;

/**
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/10
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else if (c == '}') {
                if (stack.empty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            } else if (c == ']') {
                if (stack.empty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            } else if (c == ')') {
                if (stack.empty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}
