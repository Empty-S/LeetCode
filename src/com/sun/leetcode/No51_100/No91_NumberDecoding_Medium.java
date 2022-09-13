package com.sun.leetcode.No51_100;

public class No91_NumberDecoding_Medium {
    /**
     * 题目：一条包含 A~Z 的消息通过以下映射进行了编码（A -> 1, B -> 2, ..., Z -> 26），要解码已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。
     *      例如，"11106" 可以映射为："AAJF" (1 1 10 6)，或 "KJF" (11 10 6)，注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
     *      给定一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。题目数据保证答案肯定是一个 32 位 的整数。
     * 思路：动态规划问题，长度为 len 的字符串，可能由长度为 len - 1 或 len - 2 的字符串得来，这里需要特别关注特殊值的处理
     *
     * @param s 已编码的字符串
     * @return 可能的解码总数
     */
    public static int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int len = s.length();
        // 长度为 len 的字符串，可能由长度为 len - 1 或 len - 2 的字符串得来
        // 因此 dp[n] = dp[n-1] + dp[n-2]
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            int strIdx = i - 1;
            // 此步操作可优化，比较耗时
            int doubleDigits = Integer.parseInt(s.substring(strIdx - 1, strIdx + 1));
            if (doubleDigits == 10 || doubleDigits == 20) {
                dp[i] = dp[i - 2];
            } else if (s.charAt(strIdx) == '0') {
                return 0;
            } else if (doubleDigits < 10 || doubleDigits > 26) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12")); // 2

        System.out.println(numDecodings("226")); // 3

        System.out.println(numDecodings("0")); // 0

        System.out.println(numDecodings("2101")); // 1

        System.out.println(numDecodings("10011")); // 0

        System.out.println(numDecodings("230")); // 0
    }
}
