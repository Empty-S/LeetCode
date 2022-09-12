package com.sun.leetcode.No51_100;

import com.sun.util.InputStringConvert;

import java.util.Arrays;

public class No88_CombineSortedArrays_Simple {
    /**
     * 题目：给定两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     *      合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     *      注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
     *          为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。
     *          nums2 的长度为 n 。
     * 思路：采用插入排序的思路，将 nums2 的元素插入至 nums1 中
     *
     * @param nums1 数组 1
     * @param m     数组 1 元素个数
     * @param nums2 数组 2
     * @param n     数组 2 元素个数
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0, j = 0; i < nums1.length && j < n; ) {
            if (i < m) {
                if (nums1[i] <= nums2[j]) {
                    i++;
                } else {
                    for (int k = m; k > i; k--) {
                        nums1[k] = nums1[k - 1];
                    }
                    m++;
                    nums1[i++] = nums2[j++];
                }
            } else {
                nums1[i++] = nums2[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums11 = InputStringConvert.stringToIntArray("[1,2,3,0,0,0]");
        int[] nums12 = InputStringConvert.stringToIntArray("[2,5,6]");
        merge(nums11, 3, nums12, 3);
        System.out.println(Arrays.toString(nums11));

        int[] nums21 = InputStringConvert.stringToIntArray("[1]");
        int[] nums22 = InputStringConvert.stringToIntArray("[]");
        merge(nums21, 1, nums22, 0);
        System.out.println(Arrays.toString(nums21));

        int[] nums31 = InputStringConvert.stringToIntArray("[0]");
        int[] nums32 = InputStringConvert.stringToIntArray("[1]");
        merge(nums31, 0, nums32, 1);
        System.out.println(Arrays.toString(nums31));
    }
}
