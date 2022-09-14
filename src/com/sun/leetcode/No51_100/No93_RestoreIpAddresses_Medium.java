package com.sun.leetcode.No51_100;

import java.util.ArrayList;
import java.util.List;

public class No93_RestoreIpAddresses_Medium {
    /**
     * 题目：有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *      例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     *      给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
     *      不能 重新排序或删除 s 中的任何数字，可以按 任何 顺序返回答案。
     * 思路：仍然是回溯法，用 idx 标记当前数字位置，path 记录当前 IP 各位数字
     *
     * @param s 只包含数字的字符串
     * @return 返回所有可能的 ip 地址
     */
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4) {
            return result;
        }
        DFS(s, 0, result, new ArrayList<>());
        return result;
    }

    private static void DFS(String s, int idx, List<String> result, List<String> path) {
        // 在已匹配到4个数字后，s 中的数字应已遍历完
        if (path.size() >= 4) {
            if (idx >= s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }
        for (int len = 1; len < 4 && idx + len <= s.length(); len++) {
            int num = Integer.parseInt(s.substring(idx, idx + len));
            // 不同位数的数字，所属范围不同，避免出现 023 这种三位数
            if (len == 1 && num >= 0 && num <= 9
                    || len == 2 && num >= 10 && num <= 99
                    || len == 3 && num >= 100 && num <= 255) {
                path.add(String.valueOf(num));
                DFS(s, idx + len, result, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));

        System.out.println(restoreIpAddresses("0000"));

        System.out.println(restoreIpAddresses("101023"));

        System.out.println(restoreIpAddresses("172162541"));

    }
}
