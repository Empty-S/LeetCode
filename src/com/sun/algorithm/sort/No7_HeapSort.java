package com.sun.algorithm.sort;

import java.util.Arrays;

public class No7_HeapSort {
    /**
     * 堆排序（在原数组上构建大顶堆（用于升序排列），即父节点的值均大于左右子节点
     *      此时将根节点与数组末尾位置的元素进行交换，即将最大值放到最后一位，
     *      此后再重新构造大顶堆，且 堆大小-1，直至堆仅剩一个元素）
     * 时间复杂度：Best: O(n*logn), Worst: O(n*logn), Avg: O(n*logn)
     * 空间复杂度：O(1)
     * 内部排序（占用常数内存，不占用额外内存）
     * 不稳定排序
     *
     * @param nums 待排序数组
     */
    public static void sort(int[] nums) {
        buildMaxHeap(nums);
        // 将最大值放到数组最后的位置，再重新构造大顶堆，且 heapSize - 1
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            maxHeapify(nums, 0, i);
        }
    }

    /**
     * 初始化大顶堆，从倒数第二层最右侧有子树的节点开始，由底向上构建大顶堆
     *
     * @param nums 在数组上构建大顶堆
     */
    private static void buildMaxHeap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i, nums.length);
        }
    }

    /**
     * 大顶堆处理，将较小值沉底，较大值上浮，递归调用，保证交换后子树仍为大顶堆
     *
     * @param nums     用数组存储堆
     * @param parent   父节点索引值
     * @param heapSize 堆大小（有效数组长度）
     */
    private static void maxHeapify(int[] nums, int parent, int heapSize) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        int maxIdx = parent;
        // 以下两个 if 是为了找到父节点和两个子节点中最大的值
        if (left < heapSize && nums[left] > nums[maxIdx]) {
            maxIdx = left;
        }
        if (right < heapSize && nums[right] > nums[maxIdx]) {
            maxIdx = right;
        }
        // 若存在子节点大于父节点的情况，则将父节点与最大值进行交换
        // 并再对交换后的子节点进行大顶堆处理（可能由于交换导致子树不再是大顶堆）
        if (maxIdx != parent) {
            swap(nums, maxIdx, parent);
            maxHeapify(nums, maxIdx, heapSize);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {10, 0, -1, 4, 5, 7, 3, 9, 8, 2, -4, 3};
        System.out.println("origin array: " + Arrays.toString(nums));
        sort(nums);
        System.out.println("sorted array: " + Arrays.toString(nums));
    }
}
