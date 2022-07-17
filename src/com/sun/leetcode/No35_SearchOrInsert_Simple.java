package com.sun.leetcode;

import java.util.Arrays;

public class No35_SearchOrInsert_Simple {

    /**
     * 题目：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     *      如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *      要求时间复杂度为 O(log n)
     *
     * @param nums   排序的数组
     * @param target 目标值
     * @return 目标值在数组中的当前位置或插入位置
     */
    public static int searchInsert(int[] nums, int target) {
        // 直接用 BinarySearch
        // int result = Arrays.binarySearch(nums, target);
        // return result >= 0 ? result : Math.abs(result + 1);

        // 自己实现
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums1 = {5, 7, 7, 7, 8, 8, 10};
        int target1 = 6;
        System.out.println(Arrays.binarySearch(nums1, target1));
        System.out.println(searchInsert(nums1, target1));
    }
}
