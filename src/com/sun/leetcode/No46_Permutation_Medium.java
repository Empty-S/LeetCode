package com.sun.leetcode;

import java.util.*;

public class No46_Permutation_Medium {
    /**
     * 题目：给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
     * 思路：同深度循环，向下递归。可优化点，用额外数组标记是否已加入当前路径，可以省去 List/Set copy 和 remove 操作
     *
     * @param nums 不含重复数字的数组
     * @return 全排列组合
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> numSet = new HashSet<>(nums.length);
        numSet.addAll(Arrays.stream(nums).boxed().toList());
        permuteRecurse(result, numSet, new Stack<>());
        return result;
    }

    private static void permuteRecurse(List<List<Integer>> result, Set<Integer> numSet, Stack<Integer> path) {
        if (numSet.isEmpty()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int num : numSet) {
            path.push(num);
            Set<Integer> subSet = new HashSet<>(numSet);
            subSet.remove(num);
            permuteRecurse(result, subSet, path);
            path.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
