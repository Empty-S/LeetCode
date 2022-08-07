package com.sun.algorithm.sort;

import java.util.Arrays;

public class No2_SelectSort {
    /**
     * 选择排序（从前向后遍历，将最小值放到当前位置）
     * 时间复杂度：Best: O(n^2), Worst: O(n^2), Avg: O(n^2)
     * 空间复杂度：O(1)
     * 内部排序（占用常数内存，不占用额外内存）
     * 不稳定排序
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        // 选出第 i 小的元素放置在 nums[i]
        for (int i = 0; i < nums.length; i++) {
            // 1. 在无序区找到最小值所在的位置，遍历结束后进行一次交换
            int minNumIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minNumIdx] > nums[j]) {
                    minNumIdx = j;
                }
            }
            int tmp = nums[i];
            nums[i] = nums[minNumIdx];
            nums[minNumIdx] = tmp;
//            // 2. 边找边交换位置
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    int tmp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = tmp;
//                }
//            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 0, -1, 4, 5, 7, 3, 9, 8, 2, -4, 3};
        System.out.println("origin array: " + Arrays.toString(nums));
        sort(nums);
        System.out.println("sorted array: " + Arrays.toString(nums));
    }
}
