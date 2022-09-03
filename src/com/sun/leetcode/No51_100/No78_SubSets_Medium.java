package com.sun.leetcode.No51_100;

import com.sun.util.InputStringConvert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No78_SubSets_Medium {
    /**
     * 题目：给定一个整数数组 nums ，数组中的元素 互不相同，返回该数组所有可能的子集（幂集），不能包含重复的子集。可以按 任意顺序 返回。
     * 思路：深度优先遍历
     *
     * @param nums 数字集合
     * @return 所有结果
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
//        for (int depth = 0; depth <= nums.length; depth++) {
//            DFS(nums, depth, 0, result, new Stack<>());
//        }
        DFS(nums, 0, result, new Stack<>());
        return result;
    }

    /**
     * 同层遍历如 [1,2]和[1,3]用循环实现，性能稍差
     *
     * @param nums   数字集合
     * @param depth  目标深度
     * @param idx    剩余未加入 path 的首个元素位置
     * @param result 所有结果集合
     * @param path   当前结果
     */
    private static void DFS(int[] nums, int depth, int idx, List<List<Integer>> result, Stack<Integer> path) {
        if (path.size() == depth) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            // 若当前组合元素个数 + 剩余所有元素个数 < depth，则代表即便后续所有元素都在 path 中也无法完成组合，此时进行短路逻辑，不再迭代
            if (path.size() + nums.length - i < depth) {
                return;
            }
            path.push(nums[i]);
            DFS(nums, depth, i + 1, result, path);
            path.pop();
        }
    }

    /**
     * 改进写法，用递归代替循环，性能稍好
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
        DFS(nums, idx + 1, result, path);
    }

    public static void main(String[] args) {
        System.out.println(subsets(InputStringConvert.stringToIntArray("[1,2,3]")));

        System.out.println(subsets(InputStringConvert.stringToIntArray("[0]")));
    }
}
