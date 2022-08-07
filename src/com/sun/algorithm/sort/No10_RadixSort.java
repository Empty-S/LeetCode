package com.sun.algorithm.sort;

import java.util.Arrays;

public class No10_RadixSort {
    /**
     * 基数排序（首先按个位数进行分桶，桶内无序、桶间有序，并将排序结果写回原数组，
     *          再按十位数分桶，依次类推，最终可保证全局有序）
     * 时间复杂度：Best: O(n*k), Worst: O(n*k), Avg: O(n*k)
     * 空间复杂度：O(n+k)
     * 外部排序（占用额外内存）
     * 稳定排序（排序后 2 个相等键值的顺序和排序之前它们的顺序相同）
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        int max = Math.abs(nums[0]);
        for (int num : nums) {
            max = Math.max(max, Math.abs(num));
        }
        int maxDigit = String.valueOf(Math.abs(max)).length();
        int mod = 10;
        int div = 1;
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数
            int[][] buckets = new int[20][0];
            for (int num : nums) {
                int bucketIdx = num % mod / div + 10;
                buckets[bucketIdx] = arrayAppend(buckets[bucketIdx], num);
            }
            int numsIdx = 0;
            for (int[] bucket : buckets) {
                for (int num : bucket) {
                    nums[numsIdx++] = num;
                }
            }
//            System.out.println(Arrays.toString(nums));
        }
    }

    private static int[] arrayAppend(int[] array, int value) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = value;
        return array;
    }

    public static void main(String[] args) {
        int[] nums = {10, 0, -1, 4, 57, -799, 3, -999, 8, 2, -4, 3};
        System.out.println("origin array: " + Arrays.toString(nums));
        sort(nums);
        System.out.println("sorted array: " + Arrays.toString(nums));
    }
}
