package com.sun.leetcode.No1_50;

import java.util.*;

public class No18_FourSum_Medium {
    /**
     * 题目：在nums中找到不重复的四元组，使得其和为target
     * 思路：三重循环+二分查找，与No15类似
     *      通过一些额外的条件进行剪枝，减少迭代次数
     *
     * @param nums   数组
     * @param target 目标值
     * @return 所有组合
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Set<String> resultStr = new HashSet<>();
        if (null == nums || nums.length < 4) {
            return result;
        }
        int len = nums.length;
        Arrays.sort(nums);
        // 若临近的4个数之和大于target则跳出循环
        for (int i = 0; i < len - 3 && nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] <= target; i++) {
            // 若该值与上一轮的值相同，则代表后续三个数所有可能的组合已被找到，因此无需迭代
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 若该值与数组末尾三个值相加仍比target小，则该值无需再计算后续组合
            if (nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2 && nums[i] + nums[j] + nums[j + 1] + nums[j + 2] <= target; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[j] + nums[j] + nums[len - 2] + nums[len - 1] < target) {
                    continue;
                }
                for (int k = j + 1; k < len - 1 && nums[i] + nums[j] + nums[k] + nums[k + 1] <= target; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    if (nums[j] + nums[j] + nums[k] + nums[len - 1] < target) {
                        continue;
                    }
                    int l = Arrays.binarySearch(nums, k + 1, len, target - (nums[i] + nums[j] + nums[k]));
                    if (l >= 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        int target = -11;
//        int[] nums = {2, 2, 2, 2, 2, 2};
//        int target = 8;
        System.out.println(fourSum(nums, target));
    }
}
