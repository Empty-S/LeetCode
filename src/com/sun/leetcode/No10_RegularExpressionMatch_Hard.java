package com.sun.leetcode;

public class No10_RegularExpressionMatch_Hard {

    /**
     * 题目：正则表达式匹配，支持.和*
     * 思路：从前往后逐一判断当前字符与当前模式是否匹配
     *          当前字符与当前模式的字符相匹配，结果记为flag；
     *          若当前模式含*，若flag为false，则跳过当前模式，即当前字符与下一模式匹配；
     *                      若为true，则匹配下一字符与当前模式；
     *          若当前模式不含*，若flag为false，则返回false；
     *                      若flag为true，则匹配下一字符与下一模式；
     *
     * @param s 输入字符
     * @param p 输入模式
     * @return 返回是否匹配
     */
    public static boolean isMatch(String s, String p) {
        // System.out.println("s = " + s + ", p = " + p);
        if (s == null || p == null) {
            return false;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (s.equals(p)) {
            return true;
        }
        boolean flag = s.length() != 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || flag && isMatch(s.substring(1), p);
        } else {
            return flag && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
    }

}