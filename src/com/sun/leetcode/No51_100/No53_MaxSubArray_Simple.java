package com.sun.leetcode.No51_100;

public class No53_MaxSubArray_Simple {

    /**
     * 题目：给定一个整数数组 nums ，请找出一个具有最大和的连续子数组（子数组最少包含一个元素，且子数组是数组中的一个连续部分），返回其最大和。
     * 思路：若当前sum <= 0，则与当前数字 num 累加的结果必然小于 num，因此可丢弃，从当前 num 重新开始累计
     *
     * @param nums 整数数组
     * @return 最大和
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = sum <= 0 ? num : sum + num;
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
