package com.sun.algorithm.sort;

import java.util.Arrays;

public class No9_BucketSort {
    /**
     * 桶排序（计数排序的升级版，计数排序可以看作每个桶仅有单一的 key，而桶排序为每个桶有一定范围的 key
     *      将原数组归一化到 max-min，并根据 num-min的值分组，多个桶间自然有序，仅排序桶内元素即可）
     * 时间复杂度：Best: O(n+k), Worst: O(n^2), Avg: O(n+k)
     * 空间复杂度：O(n+k)
     * 外部排序（占用额外内存）
     * 稳定排序（排序后 2 个相等键值的顺序和排序之前它们的顺序相同）
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        bucketSort(nums, 3);
    }

    private static void bucketSort(int[] nums, int bucketSize) {
        // 计算原数组中元素的最大/最下值
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // 根据桶的索引范围计算桶的个数
        int bucketCount = (max - min) / bucketSize + 1;
        // 初始化桶时，仅知道桶的个数，但不清楚每个桶中元素个数（容量），需要在遍历时动态扩容
        int[][] buckets = new int[bucketCount][0];
        for (int num : nums) {
            int bucketIdx = (num - min) / bucketSize;
            buckets[bucketIdx] = arrayAppend(buckets[bucketIdx], num);
        }
        int numsIdx = 0;
        // 遍历每个桶并对桶内元素进行排序
        for (int[] bucket : buckets) {
            if (bucket.length != 0) {
                Arrays.sort(bucket);
                // 将排序后的桶内元素写回原数组
                for (int num: bucket) {
                    nums[numsIdx++] = num;
                }
            }
        }
    }

    private static int[] arrayAppend(int[] array, int value) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = value;
        return array;
    }

    public static void main(String[] args) {
        int[] nums = {10, 0, -1, 4, 5, 7, 3, 9, 8, 2, -4, 3};
        System.out.println("origin array: " + Arrays.toString(nums));
        sort(nums);
        System.out.println("sorted array: " + Arrays.toString(nums));
    }
}
