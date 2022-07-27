package com.sun.leetcode.No1_50;

public class No45_JumpGame2_Medium {
    /**
     * 题目：给定一个非负整数数组 nums，每个元素代表在该位置可以跳跃的最大长度。
     *      求从第一个位置（下标为0）开始，最少多少次跳跃可以到达数组的最后一个位置，假设总是可以到达数组的最后一个位置。
     * 思路：每次跳跃选择 本次跳跃 + 下次跳跃可以达到最远位置的方案
     *
     * @param nums 数组
     * @return 最少的跳跃次数
     */
    public static int jump(int[] nums) {
        int result = 0;
        if (nums.length == 1) {
            return result;
        }
        for (int i = 0; i < nums.length; ) {
            result++;
            int curRange = nums[i];
            if (i + curRange >= nums.length - 1) {
                break;
            }
            int maxCurAndNextMoveLen = 0;
            int nextPos = -1;
            for (int j = 0; j < curRange; j++) {
                int curMoveLen = j + 1;
                // 有等号是为了当数值一样时，选择跳得更远的那一个
                if (curMoveLen + nums[i + curMoveLen] >= maxCurAndNextMoveLen) {
                    maxCurAndNextMoveLen = curMoveLen + nums[i + curMoveLen];
                    nextPos = i + curMoveLen;
                }
            }
            i = nextPos;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(jump(nums1));

        int[] nums2 = {0};
        System.out.println(jump(nums2));

        int[] nums3 = {2, 1};
        System.out.println(jump(nums3));

        int[] nums4 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0};
        System.out.println(jump(nums4));
    }
}
