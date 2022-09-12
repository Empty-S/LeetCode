package com.sun.leetcode.No0_Unsolved;

import java.util.Arrays;

public class No87_ScrambleString_Hard {

    public static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int[] s1Left = new int[26];
        int[] s2Left = new int[26];
        int[] s2Right = new int[26];
        for (int i = 0; i < s1.length() - 1; i++) {
            s1Left[s1.charAt(i) - 'a']++;
            s2Left[s2.charAt(i) - 'a']++;
            int reverseIdx = s2.length() - 1 - i;
            s2Right[s2.charAt(reverseIdx) - 'a']++;
            if (Arrays.equals(s1Left, s2Left)) {
                if (isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1))
                        && isScramble(s1.substring(i + 1), s2.substring(i + 1))) {
                    return true;
                }
            }
            if (Arrays.equals(s1Left, s2Right)) {
                if (isScramble(s1.substring(0, i + 1), s2.substring(reverseIdx))
                        && isScramble(s1.substring(i + 1), s2.substring(0, reverseIdx))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isScramble("great", "rgeat")); // true

        System.out.println(isScramble("abcde", "caebd")); // false

        System.out.println(isScramble("a", "a")); // true

        System.out.println(isScramble("abcdd", "dbdac")); // false

        System.out.println(isScramble("abcdbdacbdac", "bdacabcdbdac")); // true

        System.out.println(isScramble("ccababcaabcb", "bccbccaaabab")); // true

        System.out.println(isScramble("eebaacbcbcadaaedceaaacadccd", "eadcaacabaddaceacbceaabeccd")); // false，超时

    }
}