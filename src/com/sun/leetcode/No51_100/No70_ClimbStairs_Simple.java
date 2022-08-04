package com.sun.leetcode.No51_100;

public class No70_ClimbStairs_Simple {

    /**
     * 题目：假设你正在爬楼梯，需要 n 阶才能到达楼顶，每次可以爬 1 或 2 个台阶，有多少种不同的方法可以爬到楼顶？
     * 思路：动态规划问题，到达第i个阶梯有两种方法，从第 i-1 个爬 1 级，或从第 i-2 个爬 2 级
     *      即：dp[i] = dp[i-1] + dp[i-2]
     *
     * @param n 台阶数
     * @return 不同方法数
     */
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 2;
        }
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 45; i++) {
            System.out.println(climbStairs(i));
        }
    }
}
