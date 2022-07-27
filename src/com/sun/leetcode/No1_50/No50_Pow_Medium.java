package com.sun.leetcode.No1_50;

public class No50_Pow_Medium {
    /**
     * 题目：实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
     * 思路：通过将 n 转换为2进制表达，以此进行快速幂运算
     * 优化思路：递归向下
     *
     * @param x 底数
     * @param n 幂
     * @return 幂运算结果
     */
    public static double myPow(double x, int n) {
        if (x == 0 || x == 1) {
            return x;
        }
        double result = 1.0;
        boolean isPositive = n > 0;
        long tmpN = Math.abs(Long.valueOf(n)); // 防溢出
        int[] element = new int[33];
        for (int i = 0; tmpN > 0; tmpN >>= 1, i++) {
            if ((tmpN & 1) == 1) {
                element[i] = 1;
            }
        }
        double tmp = x;
        for (int i = 0; i < element.length && (1L << i) <= Math.abs(Long.valueOf(n)); i++) {
            if (i == 0) {
                tmp = x;
            } else {
                tmp *= tmp;
            }
            if (element[i] == 1) {
                result *= tmp;
            }
        }
        return isPositive ? result : 1 / result;
    }

    public static double myPowOptimize(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return half * half * rest;
    }

    public static void main(String[] args) {
//        double x = 2.00000;
//        int n = -2;
//        double x = 0.00001;
//        int n = 2147483647;
        double x = 2.00000;
        int n = -2147483648;
        System.out.println(myPow(x, n));
        System.out.println(myPowOptimize(x, n));
        System.out.println(Math.pow(x, n));
    }
}
