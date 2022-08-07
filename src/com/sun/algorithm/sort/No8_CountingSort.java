package com.sun.algorithm.sort;

import java.util.Arrays;

public class No8_CountingSort {
    /**
     * 计数排序（将数组归一化到长度为 max-min+1的数组中去，新数组的下标与原数组的值相对应，
     *          新数组记录了每个元素的出现次数，遍历新数组即可得到排序后的原数组）
     * 时间复杂度：Best: O(n+k), Worst: O(n+k), Avg: O(n+k)
     * 空间复杂度：O(k)
     * 外部排序（占用额外内存）
     * 稳定排序（排序后 2 个相等键值的顺序和排序之前它们的顺序相同）
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        // 计算原数组中元素的最大/最下值
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        // 将原数组的数据放置到长度为 max-min+1的新数组中
        // 即对原数组的元素进行归一，将 num 放置到新数组 下标 为 num-min的位置，该下标的值代表 num 的出现次数
        int[] bucket = new int[max - min + 1];
        for (int num : nums) {
            bucket[num - min]++;
        }
        // 新数组即为 从 0 ~ max-min 每个元素出现次数，遍历新数组即可得到排序后的原数组
        int numsIdx = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                // 注意此处还原值时下标需要 +min
                nums[numsIdx++] = i + min;
                bucket[i]--;
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
