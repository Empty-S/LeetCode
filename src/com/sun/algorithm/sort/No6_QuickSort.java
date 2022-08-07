package com.sun.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class No6_QuickSort {
    /**
     * 快速排序（随便找到一个元素，使其左边的元素都比它小，右边的都比它大，随后再排序其左右两边的两个子数组）
     * 时间复杂度：Best: O(n*logn), Worst: O(n^2), Avg: O(n*logn)
     * 空间复杂度：O(logn)
     * 内部排序（占用常数内存，不占用额外内存）
     * 不稳定排序
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        sort(nums, 0, nums.length);
    }

    private static void sort(int[] nums, int start, int end) {
        if (end - start <= 0) {
            return;
        }
        int mid = randomPartition(nums, start, end);
        sort(nums, 0, mid);
        sort(nums, mid + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        // 基准值选为最后一个，可选取第一、中间、最后三个值中的中间值作为基准值，来避免最坏情况。
        int pivot = nums[end - 1];
        // 从 start 开始，将比基准值小的数字放置再idx的位置
        // 当迭代到 end-1 的位置时，基准值会被换到中间位置，因此 if 条件一定要有等号 =
        int idx = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                int tmp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = tmp;
                idx++;
            }
        }
        return idx - 1;
    }

    /**
     * 随机快排：随机选中数组中的某个值，并与末尾值交换来作为随机基准值，以此避免最坏情况
     *
     * @param nums  待排序数组
     * @param start 分块起始位置
     * @param end   分块结束位置
     * @return 分块位置索引
     */
    private static int randomPartition(int[] nums, int start, int end) {
        Random random = new Random();
        int rdmIdx = random.nextInt(start, end);
        int tmp = nums[rdmIdx];
        nums[rdmIdx] = nums[end - 1];
        nums[end - 1] = tmp;
        return partition(nums, start, end);
    }

    public static void main(String[] args) {
        int[] nums = {10, 0, -1, 4, 5, 7, 3, 9, 8, 2, -4, 3};
        System.out.println("origin array: " + Arrays.toString(nums));
        sort(nums);
        System.out.println("sorted array: " + Arrays.toString(nums));
    }
}
