package com.sun.leetcode.No51_100;

public class No65_ValidNumber_Hard {

    /**
     * 题目：有效数字（按顺序）可以分成以下几个部分：
     *          1. 一个 小数 或者 整数
     *          2. （可选）一个 'e' 或 'E' ，后面跟着一个 整数
     *      小数（按顺序）可以分成以下几个部分：
     *          1. （可选）一个符号字符（'+' 或 '-'）
     *          2. 下述格式之一：
     *              1) 至少一位数字，后面跟着一个点 '.'
     *              2) 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
     *              3) 一个点 '.' ，后面跟着至少一位数字
     *      整数（按顺序）可以分成以下几个部分：
     *          1.（可选）一个符号字符（'+' 或 '-'）
     *          2.至少一位数字
     * 思路：首先按 e 进行拆分（仅含一个 e），判断第一组是否为整数或小数，且第二组为整数
     *      对于整数来说，仅第一位可为 +- 号，其余位必须是数字
     *      对于小数来说，必须仅含一个小数点，且小数点前可以仅为 +- 号或整数或没有，小数点后可以为不含 +- 号的整数或没有；
     *
     * @param s 字符串
     * @return 是否为有效数字
     */
    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.toLowerCase();
        // 用于判断 e 位置
        int eIdx = s.indexOf('e');
        int eLastIdx = s.lastIndexOf('e');
        if (eIdx != eLastIdx) {
            return false;
        }
        String[] split = s.split("e");
        if (split.length == 2 && split[0].length() != 0) {
            return (isInteger(split[0]) || isDecimal(split[0])) && isInteger(split[1]);
        } else if (!s.contains("e") && split.length == 1) {
            return isInteger(split[0]) || isDecimal(split[0]);
        } else {
            return false;
        }
    }

    private static boolean isInteger(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 首位是 +- 时，其后必须带一位数字
            if (i == 0 && (c == '+' || c == '-')) {
                if (s.length() < 2) {
                    return false;
                }
            }
            // 除首位 +- 的情况，其余位置出现非数字均为异常
            else if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private static boolean isDecimal(String s) {
        // 用于判断小数点位置
        int pointIdx = s.indexOf('.');
        int pointLastIdx = s.lastIndexOf('.');
        if (pointIdx != pointLastIdx) {
            return false;
        }
        // 必须含小数点
        if (pointIdx < 0) {
            return false;
        }
        String[] split = s.split("\\.");
        // 若小数点前后均有数字，则分别判断前后两个是否为整数，且第一个整数可以仅为 +-号，但第二个整数不能含 +- 号
        if (split.length == 2) {
            boolean part1 = split[0].equals("+") || split[0].equals("-") || isInteger(split[0]);
            boolean part2 = split[1].charAt(0) != '+' && split[1].charAt(0) != '-' && isInteger(split[1]);
            return part1 && part2;
        }
        // 若小数点位于最前，则其后的数字不能出现 +- 号
        else if (split.length == 1 && pointIdx == 0) {
            return split[0].charAt(0) != '+' && split[0].charAt(0) != '-' && isInteger(split[0]);
        }
        // 若小数点位于最后，则前面的数字直接判断是否为整数
        else if (split.length == 1) {
            return isInteger(split[0]);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isNumber("0.."));
        System.out.println(isNumber("7e69e"));
        System.out.println(isNumber("0"));
        System.out.println(isNumber("e"));
        System.out.println(isNumber("."));

        String[] valid = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        for (String str : valid) {
            System.out.println(str + ": " + isNumber(str));
        }
        String[] invalid = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
        for (String str : invalid) {
            System.out.println(str + ": " + isNumber(str));
        }
    }
}
