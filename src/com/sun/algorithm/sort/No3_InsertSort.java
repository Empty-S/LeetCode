package com.sun.algorithm.sort;

import java.util.Arrays;

public class No3_InsertSort {
    /**
     * 插入排序（从前向后遍历，第 i个元素依次与前面的元素进行比较，判断其应该插入哪里，比其大的元素整体后移一位）
     * 时间复杂度：Best: O(n), Worst: O(n^2), Avg: O(n^2)
     * 空间复杂度：O(1)
     * 内部排序（占用常数内存，不占用额外内存）
     * 稳定排序（排序后 2 个相等键值的顺序和排序之前它们的顺序相同）
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        // 从第 1 个位置起，依次判断第 i 个元素应该插入哪里
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int j = i - 1;
            // 依次与前面的元素进行比较，若当前元素较大，则后移一位
            while (j >= 0 && tmp < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 0, -1, 4, 5, 7, 3, 9, 8, 2, -4, 3};
        System.out.println("origin array: " + Arrays.toString(nums));
        sort(nums);
        System.out.println("sorted array: " + Arrays.toString(nums));
    }
}
