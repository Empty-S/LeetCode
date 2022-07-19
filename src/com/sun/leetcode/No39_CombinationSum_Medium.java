package com.sun.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No39_CombinationSum_Medium {

    /**
     * 题目：给定一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的所有 不同组合 ，并以列表形式返回，可以按 任意顺序 返回这些组合。
     *      candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * 思路：重复背包问题，采用贪心算法，优先按最大体积填充背包，再用剩余容量向下递归；
     *
     * @param candidates 可选数字
     * @param target     目标值
     * @return 所有可能组合
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序后找到 <= target的位置
        Arrays.sort(candidates);
        int maxIdx = Arrays.binarySearch(candidates, target);
        maxIdx = maxIdx >= 0 ? maxIdx : Math.abs(maxIdx + 1) - 1;
        combinationSumRecurse(candidates, maxIdx, target, result, new ArrayList<>());
        return result;
    }

    private static void combinationSumRecurse(int[] candidates, int idx, int target, List<List<Integer>> result, List<Integer> tmpResult) {
        for (int i = idx; i >= 0; i--) {
            // 背包总容量减去当前物品体积，得到剩余容量
            int left = target - candidates[i];
            if (0 == left) {
                // 若剩余容量为 0，则表示当前物品组合已满足条件，则加入结果集
                tmpResult.add(candidates[i]);
                result.add(new ArrayList<>(tmpResult));
                tmpResult.remove(tmpResult.size() - 1);
            } else if (left > 0) {
                // 若剩余容量 > 0，则表示当前物品体积无法填充剩余容量，则以当前物品继续向下递归
                tmpResult.add(candidates[i]);
                combinationSumRecurse(candidates, i, left, result, tmpResult);
                tmpResult.remove(tmpResult.size() - 1);
            }
            // 若剩余容量 < 0，则表示当前物品体积 > 背包容量，则尝试更小体积的物品
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }
}
