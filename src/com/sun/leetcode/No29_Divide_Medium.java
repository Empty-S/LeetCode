package com.sun.leetcode;

public class No29_Divide_Medium {
    /**
     * 题目：给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     *      返回被除数 dividend 除以除数 divisor 得到的商（整数部分）
     * 思路：通过减法来实现除法，进一步通过位运算加快减法迭代
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return 商（整数部分）
     */
    public static int divide(int dividend, int divisor) {
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long result = 0;
        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                result += (1L << i);
                a -= (b << i);
            }
        }
        result = ((long) dividend ^ (long) divisor) < 0 ? -result : result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 1;
        System.out.println(divide(dividend, divisor));

        divisor = -1;
        System.out.println(divide(dividend, divisor));
    }
}
