package com.sun.leetcode;

import java.util.Arrays;
import java.util.List;

public class No20_ValidBrackets_Medium {
    private static final List<Character> leftBrackets = Arrays.asList('[', '{', '(');
    private static final List<Character> rightBrackets = Arrays.asList(']', '}', ')');

    /**
     * 题目：字符串只包含[]{}()，判断字符串是否有效（左括号必须用相同类型的右括号闭合 and 左括号必须以正确的顺序闭合）
     * 思路：用数组循环模拟栈，遇到左括号一直入栈，直至遇到右括号
     *      此时用右括号与栈顶的左括号匹配，若匹配则左括号出栈，不匹配则返回false
     *
     * @param s 包含括号组合的字符串
     * @return 返回字符串是否有效
     */
    public static boolean isValid(String s) {
        // 字符串为null，或第一个字符为右括号，或最后一个为左括号，或字符各位为单数，均为false
        if (null == s || !leftBrackets.contains(s.charAt(0)) || !rightBrackets.contains(s.charAt(s.length() - 1)) || s.length() % 2 == 1) {
            return false;
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            // 第一个字符为右括号，或最后一个为左括号，均为false
            if (!leftBrackets.contains(sb.charAt(0)) || !rightBrackets.contains(sb.charAt(sb.length() - 1))) {
                return false;
            }
            // 若当前为右括号（遇到的第一个右括号），则判断是否与上一个字符匹配
            if (!leftBrackets.contains(sb.charAt(i))) {
                // 不匹配则直接返回false
                if (!isMatch(sb.charAt(i - 1), sb.charAt(i))) {
                    return false;
                }
                // 匹配则模拟出栈
                sb.delete(i - 1, i + 1);
                i -= 2;
            }
        }
        return sb.length() == 0;
    }

    private static boolean isMatch(Character left, Character right) {
        return left == '[' && right == ']'
                || left == '{' && right == '}'
                || left == '(' && right == ')';
    }

    public static void main(String[] args) {
        String s = "()[]{}";
//        String s = "{[]}";
//        String s = "([)]";
//        String s = "[]))";
        System.out.println(isValid(s));
    }
}
