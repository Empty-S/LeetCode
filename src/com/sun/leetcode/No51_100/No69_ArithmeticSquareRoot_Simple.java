package com.sun.leetcode.No51_100;

public class No69_ArithmeticSquareRoot_Simple {

    /**
     * 题目：给定一个非负整数 x ，计算 x 的算术平方根，由于返回类型是整数，结果只保留 整数部分，小数部分将被舍去。
     * 思路：寻找 i^2 > x的数字，则 i-1为 x的算术平方根
     * 优化思路：在 1 ~ x范围内进行折半查找，找到 mid=(int)x/mid的值即可，其中 mid=i+(j-i)/2
     *
     * @param x 被开放的非负整数
     * @return 算术平方根
     */
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        if (x == 2) {
            return 1;
        }
        for (int i = 0; i < x; i++) {
            if ((long) i * (long) i > x) {
                return i - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(mySqrt(i));
        }
        System.out.println(mySqrt(Integer.MAX_VALUE));
        System.out.println(Math.pow(Integer.MAX_VALUE, 0.5));
    }
}
