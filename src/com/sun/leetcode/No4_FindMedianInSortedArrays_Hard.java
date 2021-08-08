package com.sun.leetcode;

public class No4_FindMedianInSortedArrays_Hard {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0) {
            return len2 % 2 == 0 ? (double) (nums2[len2 / 2] + nums2[len2 / 2 - 1]) / 2 : nums2[len2 / 2];
        }
        if (len2 == 0) {
            return len1 % 2 == 0 ? (double) (nums1[len1 / 2] + nums1[len1 / 2 - 1]) / 2 : nums1[len1 / 2];
        }
        // totalIndex是合并数组的中位数索引值
        int totalIndex = (len1 + len2) / 2;
        // result1和2分别用来记录两个结果值
        int result1 = -1, result2 = -1;
        // m和n分别用于迭代nums1和nums2
        for (int i = 0, m = 0, n = 0; i <= totalIndex; i++) {
            result1 = result2;
            if (m < len1 && n < len2) {
                if (nums1[m] <= nums2[n]) {
                    result2 = nums1[m];
                    m++;
                } else {
                    result2 = nums2[n];
                    n++;
                }
            } else if (m >= len1) {
                result2 = nums2[n];
                n++;
            } else {
                result2 = nums1[m];
                m++;
            }
        }
        return (len1 + len2) % 2 == 0 ? (double) (result1 + result2) / 2 : result2;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
