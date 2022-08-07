package com.sun.algorithm.sort;

import java.util.Arrays;

public class No5_MergeSort {
    /**
     * 归并排序（分组排序后再合并）
     * 时间复杂度：Best: O(n*logn), Worst: O(n*logn), Avg: O(n*logn)
     * 空间复杂度：O(n)
     * 外部排序（占用额外内存）
     * 稳定排序（排序后 2 个相等键值的顺序和排序之前它们的顺序相同）
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);
        sort(left);
        sort(right);
        merge(nums, left, right);
    }

    /**
     * 合并两个有序数组
     *
     * @param result 结果数组
     * @param left   第一个有序数组
     * @param right  第二个有序数组
     */
    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0, l = 0, r = 0;
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                result[i++] = left[l++];
            } else {
                result[i++] = right[r++];
            }
        }
        while (l < left.length) {
            result[i++] = left[l++];
        }
        while (r < right.length) {
            result[i++] = right[r++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 0, -1, 4, 5, 7, 3, 9, 8, 2, -4, 3};
        System.out.println("origin array: " + Arrays.toString(nums));
        sort(nums);
        System.out.println("sorted array: " + Arrays.toString(nums));
    }
}
