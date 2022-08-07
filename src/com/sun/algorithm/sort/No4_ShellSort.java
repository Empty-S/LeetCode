package com.sun.algorithm.sort;

import java.util.Arrays;

public class No4_ShellSort {
    /**
     * 希尔排序（也称递减增量排序算法，是插入排序的一种更高效的改进版本，排序步长从 len/2 -> 1，即从粗排到精排）
     * 时间复杂度：Best: O(n*logn), Worst: O(n*logn^2), Avg: O(n*logn^2)
     * 空间复杂度：O(1)
     * 内部排序（占用常数内存，不占用额外内存）
     * 不稳定排序
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        for (int step = nums.length / 2; step >= 1; step /= 2) {
            for (int i = step; i < nums.length; i++) {
                int tmp = nums[i];
                int j = i - step;
                // 依次与前面的元素进行比较，若当前元素较大，则后移一位
                while (j >= 0 && tmp < nums[j]) {
                    nums[j + step] = nums[j];
                    j -= step;
                }
                nums[j + step] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 0, -1, 4, 5, 7, 3, 9, 8, 2, -4, 3};
        System.out.println("origin array: " + Arrays.toString(nums));
        sort(nums);
        System.out.println("sorted array: " + Arrays.toString(nums));
    }
}
