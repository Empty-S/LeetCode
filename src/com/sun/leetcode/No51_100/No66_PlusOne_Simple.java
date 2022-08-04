package com.sun.leetcode.No51_100;

import java.util.Arrays;

public class No66_PlusOne_Simple {

    /**
     * 题目：给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *      最高位数字存放在数组的首位， 数组中每个元素只存储单个数字，除了整数 0 之外，这个整数不会以零开头。
     * 思路：从最后一位向前遍历，记录每次进位值，由于仅是 +1，因此当进位值为 0时，可以停止遍历；
     *      注意对于 999 这种数字 +1后，位数变多的情况的处理。
     *
     * @param digits 表示整数的数组
     * @return 加一后的结果数组
     */
    public static int[] plusOne(int[] digits) {
        int flag = 1;
        for (int i = digits.length - 1; i >= 0 && flag > 0; i--) {
            digits[i] += flag;
            flag = digits[i] / 10;
            digits[i] %= 10;
        }
        if (flag > 0) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = flag;
            return result;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] digits1 = {1, 2, 3};
        System.out.println(Arrays.toString(plusOne(digits1)));
        int[] digits2 = {4, 3, 2, 1};
        System.out.println(Arrays.toString(plusOne(digits2)));
        int[] digits3 = {9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits3)));
    }
}
