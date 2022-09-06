package com.sun.leetcode.No51_100;

import com.sun.util.InputStringConvert;

import java.util.Arrays;

public class No81_SearchInRotatedArrayII_Medium {
    /**
     * 题目：与 No.33类似，区别在于 No.33 中数组元素不重复，本题数组元素可重复
     * 思路：核心仍然是找到原始数组的起始位置，通过顺序 + 二分查找的方式找到 start
     *      顺序遍历用于跳过重复数字，二分查找用于定位最终结果
     *
     * @param nums 要搜索的数组
     * @param target 目标值
     * @return 是否找到
     */
    public static boolean search(int[] nums, int target) {
        int start = findStart(nums);
//        System.out.println(start);
        if (target >= nums[start] && target <= nums[nums.length - 1]) {
            int idx = Arrays.binarySearch(nums, start, nums.length, target);
            return idx >= 0;
        } else if (target >= nums[0]) {
            int idx = Arrays.binarySearch(nums, 0, start, target);
            return idx >= 0;
        } else {
            return false;
        }
    }

    private static int findStart(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return 0;
        }
        int mid = (left + right) / 2;
        for (;left < mid && left < right;mid = (left + right) / 2) {
            // 跳过重复数字 start
            boolean hasRepeat = false;
            if (nums[left] == nums[left + 1]) {
                left++;
                hasRepeat = true;
            }
            if (nums[right] == nums[right - 1]) {
                right--;
                hasRepeat = true;
            }
            if (left == right) {
                return 0;
            }
            if (hasRepeat) {
                continue;
            }
            // 跳过重复数字 end
            if (nums[left] > nums[mid] || nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[left] < nums[mid] || nums[mid] > nums[right]) {
                left = mid;
            }
        }
        return nums[left] > nums[right] ? right : left;
    }

    public static void main(String[] args) {
        int[] nums1 = InputStringConvert.stringToIntArray("[2,5,6,0,0,1,2]");
        System.out.println(search(nums1, 0));

        int[] nums2 = InputStringConvert.stringToIntArray("[2,5,6,0,0,1,2]");
        System.out.println(search(nums2, 3));

        int[] nums3 = InputStringConvert.stringToIntArray("[2,2,2,3,2,2,2]");
        System.out.println(search(nums3, 3));

        int[] nums4 = InputStringConvert.stringToIntArray("[1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1]");
        System.out.println(search(nums4, 2));
    }
}