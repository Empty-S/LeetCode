package com.sun.leetcode.No0_Unsolved;

public class No44_WildCardMatch_Hard {
    /**
     * 题目：给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     *
     * @param s 字符串
     * @param p 字符模式
     * @return 匹配结果
     */
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        // 记录 p 中有多少非 * 的字符
        if (p.length() > 0) {
            // 将连续的多个 * 简化为1个
            StringBuilder sb = new StringBuilder();
            sb.append(p.charAt(0));
            for (int i = 1; i < p.length(); i++) {
                if (p.charAt(i) != '*') {
                    sb.append(p.charAt(i));
                } else if (p.charAt(i - 1) != '*') {
                    sb.append(p.charAt(i));
                }
            }
            p = sb.toString();
//            System.out.println(p);
        }
        return isMatchRecurse(s, p);
    }

    private static boolean isMatchRecurse(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (s.length() == 0) {
            return p.equals("*");
        }
        if (p.charAt(0) == '?' || s.charAt(0) == p.charAt(0)) {
            return isMatchRecurse(s.substring(1), p.substring(1));
        }
        if (p.charAt(0) == '*') {
            if (p.length() > 1) {
                char pNextChar = p.charAt(1);
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == pNextChar && isMatchRecurse(s.substring(i + 1), p.substring(2))) {
                        return true;
                    }
                }
                return false;
            } else {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "aa")); // true
        System.out.println(isMatch("adceb", "*a*b")); // true
        System.out.println(isMatch("mississippi", "m??*ss*?i*pi")); // false
        System.out.println(isMatch("", "*******")); // true
        System.out.println(isMatch("ab", "?*")); // true
        System.out.println(isMatch("abcabczzzde", "*abc???de*")); // true
        System.out.println(isMatch("aaaa", "*a")); // true
        System.out.println(isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
    }
}