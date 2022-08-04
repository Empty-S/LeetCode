package com.sun.leetcode.No51_100;

public class No67_AddBinary_Simple {

    /**
     * 题目：给你两个二进制字符串，返回它们的和（用二进制表示），输入为 非空 字符串且只包含数字 1 和 0。
     * 思路：首先同时从最后一位迭代，并记录进位值，与 No66类似，
     *      注意当其中一个字符串迭代完后，须将剩下的进位值与另一个字符串的值继续写入
     *      当两个字符串均加完后，注意需将不为 0 的进位值添加到首位
     * 优化思路：直接将每一位的计算结果写到较长的字符串中，可节省内存开销
     *
     * @param a 字符串表示的二进制a
     * @param b 字符串表示的二进制b
     * @return 和的结果
     */
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int flag = 0;
        while (i >= 0 && j >= 0) {
            int cur = a.charAt(i--) - '0' + b.charAt(j--) - '0' + flag;
            flag = cur / 2;
            cur %= 2;
            result.insert(0, cur);
        }
        while (i >= 0) {
            int cur = a.charAt(i--) - '0' + flag;
            flag = cur / 2;
            cur %= 2;
            result.insert(0, cur);
        }
        while (j >= 0) {
            int cur = b.charAt(j--) - '0' + flag;
            flag = cur / 2;
            cur %= 2;
            result.insert(0, cur);
        }
        if (flag > 0) {
            result.insert(0, flag);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String a1 = "1", b1 = "111";
        System.out.println(addBinary(a1, b1));
        String a2 = "1010", b2 = "1011";
        System.out.println(addBinary(a2, b2));
    }
}
