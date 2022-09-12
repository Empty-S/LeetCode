package com.sun.leetcode.No51_100;

import java.util.ArrayList;
import java.util.List;

public class No89_GrayCode_Medium {
    /**
     * 题目：n 位格雷码序列 是一个由 2^n 个整数组成的序列，其中：
     *          - 每个整数都在范围 [0, 2^n - 1] 内（含 0 和 2^n - 1）
     *          - 第一个整数是 0
     *          - 一个整数在序列中出现 不超过一次
     *          - 每对 相邻 整数的二进制表示 恰好一位不同 ，且
     *          - 第一个 和 最后一个 整数的二进制表示 恰好一位不同
     *      给定一个整数 n ，返回任一有效的 n 位格雷码序列 。
     * 思路：根据格雷码的特性，采用对称生成的方式，即 n 位的格雷码 = n-1 位的格雷码 + n-1 位格雷码逆序且最高位（最左）为 1
     *
     * @param n 位 Gray 编码，也是整数二进制表示的最大长度
     * @return 返回其中一个有效结果
     */
    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>((int) Math.pow(2, n));
        result.add(0);
        for (int i = 1; i <= n; i++) {
            int lastLen = result.size();
            // 逆序遍历 n-1 位的格雷码，并在最高位填 1
            for (int j = lastLen - 1; j >= 0; j--) {
                result.add(result.get(j) | 1 << (i - 1));
            }
        }
        return result;
    }

//    public static List<Integer> grayCode(int n) {
//        int len = (int) Math.pow(2, n);
//        Stack<Integer> result = new Stack<>();
//        // 标记该数字是否已被使用， 0 = 未被使用，1 = 已被使用
//        int[] flag = new int[len];
//        // 首位是 0
//        result.add(0);
//        flag[0] = 1;
//        generateGrayCode(n, result, flag);
//        return result;
//    }
//
//    /**
//     * 回溯法生成结果，找到其中一个满足条件的结果时返回，停止迭代
//     *
//     * @param n    n位 Gray 编码，也是整数二进制表示的最大长度
//     * @param path 保存当前已生成的序列
//     * @param flag 标记当前已使用的数字
//     * @return 当前序列是否有效
//     */
//    private static boolean generateGrayCode(int n, Stack<Integer> path, int[] flag) {
//        if (path.size() == flag.length) {
//            // 判断最后一个数字与第一位数字是否仅有一位不同
//            return diffBitsCount(path.peek(), 0) == 1;
//        }
//        String lastBinaryStr = Integer.toBinaryString(path.peek());
//        char[] lastBinaryArr = new char[n];
//        Arrays.fill(lastBinaryArr, '0');
//        System.arraycopy(lastBinaryStr.toCharArray(), 0, lastBinaryArr, n - lastBinaryStr.length(), lastBinaryStr.length());
//        for (int i = 0; i < n; i++) {
//            char[] tmp = Arrays.copyOf(lastBinaryArr, n);
//            tmp[i] = tmp[i] == '0' ? '1' : '0';
//            int next = Integer.parseInt(String.valueOf(tmp), 2);
//            if (flag[next] == 0) {
//                path.push(next);
//                flag[next] = 1;
//                if (generateGrayCode(n, path, flag)) {
//                    return true;
//                }
//                path.pop();
//                flag[next] = 0;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * 判断两个整数有多少个比特位不相同
//     *
//     * @param m 整数1
//     * @param n 整数2
//     * @return 不同的比特位数
//     */
//    private static int diffBitsCount(int m, int n) {
//        int count = 0;
//        int tmp = m ^ n;
//        while (tmp != 0) {
//            count++;
//            tmp = tmp & (tmp - 1);
//        }
//        return count;
//    }

    public static void main(String[] args) {
        System.out.println(grayCode(1));

        System.out.println(grayCode(2));
    }
}
