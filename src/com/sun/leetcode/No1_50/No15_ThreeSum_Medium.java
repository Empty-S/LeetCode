package com.sun.leetcode.No1_50;

import java.util.*;

public class No15_ThreeSum_Medium {
    /**
     * 题目：在nums中找到不重复的三元组，使得其和为0
     * 思路：双重循环+二分查找，与No18类似
     *      通过一些额外的条件进行剪枝，减少迭代次数
     *
     * @param nums 数组
     * @return 所有组合
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int target = 0;
        // 若临近的3个数之和大于target则跳出循环
        for (int i = 0; i < nums.length - 2 && nums[i] + nums[i + 1] + nums[i + 2] <= target; i++) {
            // 若该值与上一轮的值相同，则代表后续三个数所有可能的组合已被找到，因此无需迭代
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 若该值与数组末尾三个值相加仍比target小，则该值无需再计算后续组合
            if (nums[i] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1 && nums[i] + nums[j] + nums[j + 1] <= target; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[len - 1] < target) {
                    continue;
                }
                int k = Arrays.binarySearch(nums, j + 1, nums.length, target - nums[i] - nums[j]);
                if (k >= 0) {
                    results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {

    }
}
