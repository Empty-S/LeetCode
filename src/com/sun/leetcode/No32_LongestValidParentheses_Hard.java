package com.sun.leetcode;

import java.util.Stack;

public class No32_LongestValidParentheses_Hard {
    /**
     * 题目：给定一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * 思路：将 s 按照有效字串进行拆分，有效子串所在位置每一位都记为0，其余记为1，即对于 s = ')(()))'来说，记为100001
     *      再进行最长0串进行计算即可
     *
     * @param s 只包含括号的字符串
     * @return 最长字串的长度
     */
    public static int longestValidParentheses(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }
        // 将原字符串 s 中每个有效子串进行标记
        int[] marks = new int[s.length()];
        // 记录每一个左括号位置
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                marks[i] = 0;
                marks[stack.pop()] = 0;
            } else {
                marks[i] = 1;
            }
        }
        while (!stack.isEmpty()) {
            marks[stack.pop()] = 1;
        }

        int maxResult = 0; // 最大的字串长度
        int result = 0; // 每个子串长度
        for (int mark : marks) {
            if (mark == 1) {
                maxResult = Math.max(result, maxResult);
                result = 0;
            } else {
                result++;
            }
        }
        maxResult = Math.max(result, maxResult);
        return maxResult;
    }

    public static void main(String[] args) {
        String s = ")()()(((()))";
        System.out.println(longestValidParentheses(s));
    }
}
