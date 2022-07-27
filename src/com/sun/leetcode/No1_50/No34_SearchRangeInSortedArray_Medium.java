package com.sun.leetcode.No1_50;

import java.util.Arrays;

public class No34_SearchRangeInSortedArray_Medium {

    /**
     * 题目：给定一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
     *      请找出 target 在数组中的开始位置和结束位置。如果数组中不存在 target，返回 [-1, -1]。
     *      要求时间复杂度为 O(log n)
     * 思路：二分查找的变种，一个查找起始位置，一个查找结束位置
     *
     * @param nums   非递减排列的数组
     * @param target 目标值
     * @return 起止位置
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = searchFloor(nums, target);
        result[1] = searchCeil(nums, target);
        return result;
    }

    private static int searchFloor(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    private static int searchCeil(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right >= 0 && nums[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 8, 8, 10};
        int target1 = 6;
        System.out.println(Arrays.toString(searchRange(nums1, target1)));
    }
}
