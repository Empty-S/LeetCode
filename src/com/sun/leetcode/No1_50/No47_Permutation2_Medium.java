package com.sun.leetcode.No1_50;

import java.util.*;

public class No47_Permutation2_Medium {
    /**
     * 题目：给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * 思路：同深度循环，向下递归。为保证无重复结果，先将 nums 排序，随后在同深度循环中遇到已出现过的数字，跳过即可（也可使用Set保存结果）
     *
     * @param nums 不含重复数字的数组
     * @return 全排列组合
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int[] flag = new int[nums.length];
        permuteRecurse(result, nums, flag, new Stack<>());
        return result;
    }

    private static void permuteRecurse(List<List<Integer>> result, int[] nums, int[] flag, Stack<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == 1 || i > 0 && nums[i] == nums[i - 1] && flag[i] == flag[i - 1]) {
                continue;
            }
            path.push(nums[i]);
            flag[i] = 1;
            permuteRecurse(result, nums, flag, path);
            flag[i] = 0;
            path.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(permuteUnique(nums));
    }
}
