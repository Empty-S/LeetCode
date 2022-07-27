package com.sun.leetcode.No1_50;

import java.math.BigInteger;

public class No43_StringMultiply_Medium {
    /**
     * 题目：给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
     *      1 <= num1.length, num2.length <= 200
     *      num1 和 num2 只能由数字组成。
     *      num1 和 num2 都不包含任何前导零，除了数字 0本身。
     * 思路：按照乘法计算公式，用乘数的每一位 × 被乘数，最后将每次结果相加
     * 优化思路：两数相乘的结果长度为 n+m-1 或 n+m，将num1[i] * num2[j]的结果累加至 result[i+j+1]即可（为m+n长度的结果预留一位）
     *          由于累加后的 result[k] 结果位数可能 >1，因此要从最后一位起处理进位
     *
     * @param num1 被乘数
     * @param num2 乘数
     * @return 结果字符串
     */
    public static String multiplyOptimize(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // TODO
        return null;
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String result = "0";
        String endZero = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int n2 = num2.charAt(i) - '0';
            String tmp = "0";
            for (int j = 0; j < n2; j++) {
                tmp = add(tmp, num1);
            }
            if (!tmp.equals("0")) {
                tmp += endZero;
            }
            result = add(result, tmp);
            endZero += "0";
        }
        return result;
    }

    private static String add(String num1, String num2) {
        if (num1.equals("0")) {
            return num2;
        }
        if (num2.equals("0")) {
            return num1;
        }
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        for (; i >= 0 & j >= 0; i--, j--) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(j) - '0';
            int sum = n1 + n2 + flag;
            flag = sum / 10;
            sb.insert(0, sum % 10);
        }
        for (; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            int sum = n1 + flag;
            flag = sum / 10;
            sb.insert(0, sum % 10);
        }
        for (; j >= 0; j--) {
            int n2 = num2.charAt(j) - '0';
            int sum = n2 + flag;
            flag = sum / 10;
            sb.insert(0, sum % 10);
        }
        if (flag != 0) {
            sb.insert(0, flag);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(add("7775089", "5068790"));
        System.out.println(7775089 + 5068790);

        System.out.println(multiply("498828660196", "840477629533"));
        System.out.println(BigInteger.valueOf(498828660196L).multiply(BigInteger.valueOf(840477629533L)));
    }
}
