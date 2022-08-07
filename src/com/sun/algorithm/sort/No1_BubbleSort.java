package com.sun.algorithm.sort;

import java.util.Arrays;

public class No1_BubbleSort {
    /**
     * 冒泡排序（从后向前遍历，相邻元素两两比较，将较小值换到最前面）
     * 时间复杂度：Best: O(n), Worst: O(n^2), Avg: O(n^2)
     * 空间复杂度：O(1)
     * 内部排序（占用常数内存，不占用额外内存）
     * 稳定排序（排序后 2 个相等键值的顺序和排序之前它们的顺序相同）
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        // 布尔值用于判断第 i 次循环中是否有元素位置交换，若无，则代表元素已整体有序，可不再执行
        boolean hasExchange = true;
        // 选出第 i 小的元素放置在 nums[i]
        for (int i = 0; i < nums.length && hasExchange; i++) {
            hasExchange = false;
            // 从最后一个位置开始，相邻元素两两比较，将较小的位置前移，类似沉底的泡泡上浮到最前面
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j - 1] > nums[j]) {
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                    hasExchange = true;
                    System.out.println(Arrays.toString(nums));
                }
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
