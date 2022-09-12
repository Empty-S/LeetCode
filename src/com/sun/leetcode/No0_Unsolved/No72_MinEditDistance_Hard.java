package com.sun.leetcode.No0_Unsolved;

public class No72_MinEditDistance_Hard {
    /**
     * 题目：给定两个单词 word1 和 word2，请返回将 word1 转换成 word2 所使用的最少操作数。、
     * 对一个单词可以有如下三种操作：插入、删除、替换一个字符
     * 思路：从两个单词末尾向前遍历，尽可能多的将 word2 中的字符匹配到 word1 上，若 word2 中第 j 个字符，与 word1 中 0~i个字符均不匹配，则跳过
     *
     * @param word1 待转换单词
     * @param word2 目标单词
     * @return 最少操作数
     */
    public static int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        int i = 0;
        int j = 0;
        while (i < word1.length() && j < word2.length() && word1.charAt(i) == word2.charAt(j)) {
            i++;
            j++;
        }
        int word1Left = word1.length() - i;
        int word2Left = word2.length() - j;
        if (word1Left <= 0 || word2Left <= 0) {
            return Math.max(word1Left, word2Left);
        } else {
            int insert = 1 + minDistance(word1.substring(i), word2.substring(j + 1));
            int modify = 1 + minDistance(word1.substring(i + 1), word2.substring(j + 1));
            int tmpResult1 = Math.min(insert, modify);
            int k = word1.indexOf(word2.charAt(j), i);
            if (k < 0) {
                // word2[j]没匹配上时，要么在 i 前插入一个 word2[j]，要么修改 word1[i]
                return tmpResult1;
            } else {
                // word2[j] == word1[k]时，
                int match = k - i + minDistance(word1.substring(k + 1), word2.substring(j + 1));
                int skip = k - i + minDistance(word1.substring(k + 1), word2.substring(j));
                int tmpResult2 = Math.min(match, skip);
                return Math.min(tmpResult1, tmpResult2);
            }
        }
    }

    private static int reverseMatch(String word1, String word2) {
        int result = 0;
        int i = word1.length() - 1;
        int j = word2.length() - 1;
        // 记录 word2 中相邻两个匹配上的字符之间相隔几个字符
        int misMatched = 0;
        for (; j >= 0; j--) {
            int k = i;
            while (k >= 0 && word1.charAt(k) != word2.charAt(j)) {
                k--;
            }
            if (k < 0) { // word2[j]没匹配上
                misMatched++;
                result++;
            } else { // word2[j] == word1[k]
                result += Math.max(i - k - misMatched, 0); // 没匹配上的结果与间隔字符的处理去重
                i = k - 1;
                misMatched = 0;
            }
        }
        if (i >= 0) {
            result += Math.max(i + 1 - misMatched, 0);
        }
        return result;
    }

    private static int positiveMatch(String word1, String word2) {
        return reverseMatch(new StringBuilder(word1).reverse().toString(), new StringBuilder(word2).reverse().toString());
    }

    public static void main(String[] args) {
        String word11 = "horse", word21 = "ros";
        System.out.println(minDistance(word11, word21)); // 3

        String word12 = "intention", word22 = "execution";
        System.out.println(minDistance(word12, word22)); // 5

        String word13 = "b", word23 = "";
        System.out.println(minDistance(word13, word23)); // 1

        String word14 = "mart", word24 = "karma";
        System.out.println(minDistance(word14, word24)); // 3

        String word15 = "prosperity", word25 = "properties";
        System.out.println(minDistance(word15, word25)); // 4

        String word16 = "pneumonoultramicroscopicsilicovolcanoconiosis", word26 = "ultramicroscopically";
        System.out.println(minDistance(word16, word26)); // 27
    }
}