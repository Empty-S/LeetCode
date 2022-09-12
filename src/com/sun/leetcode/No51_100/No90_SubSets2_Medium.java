package com.sun.leetcode.No51_100;

import com.sun.util.InputStringConvert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class No90_SubSets2_Medium {
    /**
     * 题目：给定一个整数数组 nums ，其中可能包含重复元素，请返回该数组所有可能的子集（幂集）。
     *      解集不能包含重复的子集，返回的解集中，子集可以按 任意顺序 排列。
     * 思路：
     *
     * @param nums 原始集合
     * @return 幂集
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序用于跳过重复数字
        Arrays.sort(nums);
        DFS(nums, 0, result, new Stack<>());
        return result;
    }

    /**
     * 深度优先遍历
     *
     * @param nums   数字集合
     * @param idx    剩余未加入 path 的首个元素位置
     * @param result 所有结果
     * @param path   当前结果
     */
    private static void DFS(int[] nums, int idx, List<List<Integer>> result, Stack<Integer> path) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        path.push(nums[idx]);
        DFS(nums, idx + 1, result, path);
        path.pop();
        // 下面一次 DFS() 为同层遍历
        // 跳过重复数字
        while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        DFS(nums, idx + 1, result, path);
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(InputStringConvert.stringToIntArray("[1,2,2]")));

        System.out.println(subsetsWithDup(InputStringConvert.stringToIntArray("[0]")));
    }
}
