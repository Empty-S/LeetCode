package com.sun.leetcode.No51_100;

public class No55_CanJump_Medium {

    /**
     * 题目：给定一个非负整数数组 nums ，你最初位于数组的 第一个下标，数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *      判断你是否能够到达最后一个下标。
     * 思路：从倒数第二个数字开始向前循环，判断当前位置的距离是否可以达到目标位置
     *      若可以，则更新目标位置为当前位置，若不可以则继续向前寻找可行方案；
     *
     * @param nums 非负整数数组
     * @return 是否有解
     */
    public static boolean canJump(int[] nums) {
        int targetPos = nums.length - 1;
        for (int i = targetPos - 1; i >= 0; i--) {
            if (nums[i] >= targetPos - i) {
                targetPos = i;
            }
        }
        return targetPos == 0;
//        return canJumpRecurse(nums, nums.length - 1);
    }

    // 递归方案
    public static boolean canJumpRecurse(int[] nums, int endIdx) {
        if (endIdx == 0) {
            return true;
        }
        int minIdx = endIdx;
        for (int i = endIdx - 1; i >= 0; i--) {
            if (nums[i] >= endIdx - i) {
                minIdx = i;
            }
        }
        if (minIdx == endIdx) {
            return false;
        } else {
            return canJumpRecurse(nums, minIdx);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums1));

        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums2));

        int[] nums3 = {2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6};
        System.out.println(canJump(nums3));
    }
}
