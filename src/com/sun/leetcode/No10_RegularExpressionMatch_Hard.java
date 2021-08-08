package com.sun.leetcode;

public class No10_RegularExpressionMatch_Hard {

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