package com.sun.leetcode.No1_50;

import java.util.*;

public class No40_CombinationSum2_Medium {

    /**
     * 题目：给定一个整数数组 candidates 和一个目标数 target ，找出 candidates 中可以使数字和为 target 的组合。
     *      candidates 中的每个数字在每个组合中只能使用 一次，解集不能包含重复的组合。
     * 思路：无重背包问题
     *
     * @param candidates 可选数字
     * @param target     目标值
     * @return 所有可能组合
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序后找到 <= target的位置
        Arrays.sort(candidates);
        combinationSumRecurse(candidates, candidates.length - 1, target, result, new ArrayList<>());
        return result;
    }

    private static void combinationSumRecurse(int[] candidates, int idx, int target, List<List<Integer>> result, List<Integer> path) {
        // 若剩余容量为 0，则表示当前物品组合已满足条件，则加入结果集
        if (target == 0) {
            result.add(new ArrayList<>(path));
        }
        for (int i = idx; i >= 0; i--) {
            if (i < idx && candidates[i] == candidates[i + 1]) {
                continue;
            }
            // 背包总容量减去当前物品体积，得到剩余容量
            int left = target - candidates[i];
            // 若剩余容量 < 0，则表示当前物品体积 > 背包容量，则尝试更小体积的物品
            if (left >= 0) {
                // 若剩余容量 > 0，则表示当前物品体积无法填满背包，则以下一物品继续向下递归
                path.add(candidates[i]);
                combinationSumRecurse(candidates, i - 1, left, result, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
//        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
//        int target = 8;
        int[] candidates = {3, 1, 3, 5, 1, 1};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

//    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        HashSet<List<Integer>> result = new HashSet<>();
//        TreeMap<Integer, Integer> candidateMap = new TreeMap<>(Comparator.reverseOrder());
//        for (int num : candidates) {
//            Integer count = candidateMap.putIfAbsent(num, 1);
//            if (null != count) {
//                candidateMap.put(num, count + 1);
//            }
//        }
//        combinationSumRecurse(candidateMap, target, result, new ArrayList<>());
//        return result.stream().toList();
//    }
//
//    private static void combinationSumRecurse(TreeMap<Integer, Integer> candidateMap, int target, HashSet<List<Integer>> result, List<Integer> tmpResult) {
//        for (Map.Entry<Integer, Integer> entry : candidateMap.entrySet()) {
//            int num = entry.getKey();
//            int count = entry.getValue();
//            if (count <= 0) {
//                continue;
//            }
//            // 背包总容量减去当前物品体积，得到剩余容量
//            int left = target - num;
//            // 若剩余容量 < 0，则表示当前物品体积 > 背包容量，则尝试更小体积的物品
//            if (left < 0) {
//                continue;
//            }
//            candidateMap.put(num, count - 1);
//            tmpResult.add(num);
//            if (0 == left) {
//                // 若剩余容量为 0，则表示当前物品组合已满足条件，则加入结果集
//                List<Integer> r = new ArrayList<>(tmpResult);
//                Collections.sort(r);
//                result.add(r);
//            } else {
//                // 若剩余容量 > 0，则表示当前物品体积无法填满背包，则以相同体积的物品或下一个物品继续向下递归
//                combinationSumRecurse(candidateMap, left, result, tmpResult);
//            }
//            candidateMap.put(num, count);
//            tmpResult.remove(tmpResult.size() - 1);
//        }
//    }
}
