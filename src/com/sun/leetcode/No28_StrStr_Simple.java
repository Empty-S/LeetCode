package com.sun.leetcode;

public class No28_StrStr_Simple {
    /**
     * 题目：两个字符串 haystack 和 needle ，在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
     *      如果不存在，则返回 -1
     * 思路：迭代 haystack中的每个长度为needle.len的子串，看是否与needle匹配
     *
     * @param haystack 父字符串
     * @param needle 要匹配的字符串
     * @return needle首次出现位置
     */
    public static int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.startsWith(needle, i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.println(strStr(haystack, needle));
    }
}
