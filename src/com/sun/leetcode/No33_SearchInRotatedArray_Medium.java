package com.sun.leetcode;

import java.util.Arrays;

public class No33_SearchInRotatedArray_Medium {
    /**
     * 题目：整数数组 nums 按升序排列，数组中的值 互不相同 。
     *      在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了旋转，
     *      使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
     *      例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     *      给定旋转后的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     *      要求时间复杂度为 O(log n)
     * 思路：先通过二分查找的方式找到旋转点 k，再根据 target 与两段数组起止值的比较在不同区间内进行二分查找
     *
     * @param nums   旋转后的数组
     * @param target 要搜索的目标
     * @return 返回位置
     */
    public static int search(int[] nums, int target) {
        int k = findK(nums);
        System.out.println(k);
        if (target <= nums[nums.length - 1]) {
            int idx = Arrays.binarySearch(nums, k, nums.length, target);
            return idx < 0 ? -1 : idx;
        } else if (target >= nums[0]) {
            int idx = Arrays.binarySearch(nums, 0, k, target);
            return idx < 0 ? -1 : idx;
        } else {
            return -1;
        }
    }

    private static int findK(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (true) {
            mid = (left + right) / 2;
            if (nums[left] < nums[right]) {
                return 0;
            } else if (nums[left] == nums[mid]) {
                return right;
            } else if (nums[left] > nums[mid]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid;
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
//        int[] nums = {0, 1, 2, 4, 5, 6, 7};
//        int[] nums = {1, 2, 4, 5, 6, 7, 0};
//        int[] nums = {7, 0, 1, 2, 4, 5, 6};
//        int[] nums = {7};
//        int[] nums = {1, 3};
//        System.out.println(findK(nums));

//        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
//        int target1 = 3;
//        System.out.println(search(nums1, target1));
//
//        int[] nums2 = {1};
//        int target2 = 0;
//        System.out.println(search(nums2, target2));

        int[] nums3 = {1, 3};
        int target3 = 2;
        System.out.println(search(nums3, target3));
    }
}
