package com.sun.leetcode.No51_100;

import java.util.Arrays;

public class No76_MinCoverSubString_Hard {
    /**
     * 题目：给定一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *      - 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     *      - 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     * 思路：前置判断：若 s 的子串全包含 t，则 sLen >= tLen，且 s 中字符出现的次数 >= t 中字符出现次数
     *      使用两个索引 start 和 end 标记窗口起止位置，首先扩展右边界，在窗口长度达到 tLen 后，每次扩展右边界都需判断 子串是否全包含 t；
     *      当找打一个结果后，则尝试缩短左边界，判断是否可以找到更短的子串；若找不到 或 窗口长度已小于 tLen，则继续扩展右边界；
     *      当 end 已经到达右边界，但没有成功找到子串时，认为搜索结束，返回当前最小结果；
     *      当 start = sLen - tLen时（end = sLen - 1），此时为所有可能的最后一个窗口。
     *
     * @param s 搜索字符串
     * @param t 目标字符串
     * @return s中的最小子串
     */
    public static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        String minStr = "";
        int minStrLen = Integer.MAX_VALUE;
        // 若 s 长度小于 t，则一定不含 t 的所有字符
        if (sLen < tLen) {
            return minStr;
        }
        // 统计 s 和 t 中每个字符出现的次数
        int[] sCharCnt = new int[26 * 2];
        int[] tCharCnt = new int[26 * 2];
        for (int i = 0; i < sLen; i++) {
            sCharCnt[charIndexMap(s.charAt(i))]++;
            if (i < tLen) {
                tCharCnt[charIndexMap(t.charAt(i))]++;
            }
        }
        // 若 s 与 t 长度相同，则仅当字符统计完全一致时，s 全包含 t
        if (sLen == tLen) {
            if (Arrays.equals(sCharCnt, tCharCnt)) {
                return s;
            } else {
                return minStr;
            }
        }
        // 若 t 中存在 s 中没有的字符，或 t 中某字符个数大于 s 中的该字符个数，则失败
        for (int i = 0; i < sCharCnt.length; i++) {
            if (sCharCnt[i] < tCharCnt[i]) {
                return minStr;
            }
        }
        int start = 0;
        int end = 0;
        int[] subCharCnt = new int[26 * 2];
        while (start <= sLen - tLen) {
            // 若 start 所在的字符未出现再 t 中，则持续缩进左边界，即 start++
            if (tCharCnt[charIndexMap(s.charAt(start))] == 0) {
                // 首次循环，start == end时，需要同时将 start 和 end 右移
                if (end == start) {
                    end++;
                }
                start++;
                continue;
            }
            // 标记是否成功找到子串
            boolean isMatch = false;
            for (; end < sLen; end++) {
                subCharCnt[charIndexMap(s.charAt(end))]++;
                // 若当前窗口长度 < tLen时，则继续扩展右边界，即 end++
                if (end - start + 1 < tLen) {
                    continue;
                }
                // 判断子串是否全包含 t，若是，则再判断子串长度是否 < minStrLen，若是则更新 minStr
                if (arrayContains(subCharCnt, tCharCnt)) {
                    if (end - start + 1 < minStrLen) {
                        minStr = s.substring(start, end + 1);
                        minStrLen = end - start + 1;
                    }
                    isMatch = true;
                    break;
                }
            }
            // 若没匹配到，则 end 一定已经到达 s.len，因此无需后续循环
            if (!isMatch) {
                return minStr;
            }
            // 若匹配到，则尝试缩短左边界，即 start++
            subCharCnt[charIndexMap(s.charAt(start))]--;
            start++;
            // 右边界的字符统计需要 -1，否则会被重复统计
            subCharCnt[charIndexMap(s.charAt(end))]--;
        }
        return minStr;
    }

    private static int charIndexMap(char c) {
        if (c >= 'A' & c <= 'Z') {
            return c - 'A';
        } else if (c >= 'a' && c <= 'z') {
            return c - 'a' + 26;
        }
        return -1;
    }

    private static boolean arrayContains(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println(minWindow(s1, t1));

        String s2 = "a";
        String t2 = "a";
        System.out.println(minWindow(s2, t2));

        String s3 = "a";
        String t3 = "aa";
        System.out.println(minWindow(s3, t3));

        String s4 = "ab";
        String t4 = "b";
        System.out.println(minWindow(s4, t4));

        String s5 = "cabwefgewcwaefgcf";
        String t5 = "cae";
        System.out.println(minWindow(s5, t5));
    }
}
