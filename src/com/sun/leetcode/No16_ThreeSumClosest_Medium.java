package com.sun.leetcode;

public class No16_ThreeSumClosest_Medium {
    /**
     * 题目：数组中找到三个数之和最接近target的组合
     * 思路：暴力循环，当sum与target差值为0时提前终止循环
     *
     * @param nums 数组
     * @param target 目标值
     * @return 三数之和
     */
    public static int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < minDiff) {
                        minDiff = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        sum = nums[i] + nums[j] + nums[k];
                        if (minDiff == 0) {
                            return sum;
                        }
                    }
//                    System.out.println(nums[i] + ", " + nums[j] + ", " + nums[k]);
//                    System.out.println("minDiff: " + minDiff);
//                    System.out.println("sum: " + sum);
//                    System.out.println();
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128};
        int target = 82;
        System.out.println(threeSumClosest(nums, target));
    }
}
