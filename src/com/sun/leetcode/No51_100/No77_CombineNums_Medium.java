package com.sun.leetcode.No51_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No77_CombineNums_Medium {
    /**
     * 题目：给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合，可以按 任何顺序 返回答案。
     * 思路：深度优先遍历，注意短路逻辑加快遍历
     *
     * @param n 数字范围
     * @param k 每个组合中元素个数
     * @return 所有结果
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineRecurse(n, k, 1, result, new Stack<>());
        return result;
    }

    private static void combineRecurse(int n, int k, int idx, List<List<Integer>> result, Stack<Integer> path) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i <= n; i++) {
            // 若当前组合元素个数 + 剩余所有元素个数 < k，则代表即便后续所有元素都在 path 中也无法完成组合，此时进行短路逻辑，不再迭代
            if (path.size() + n - i + 1 < k) {
                return;
            }
            path.push(i);
            combineRecurse(n, k, i + 1, result, path);
            path.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));

        System.out.println(combine(1, 1));

    }
}
