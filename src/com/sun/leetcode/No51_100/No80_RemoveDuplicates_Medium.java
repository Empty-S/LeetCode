package com.sun.leetcode.No51_100;

import com.sun.util.InputStringConvert;

import java.util.Arrays;

public class No80_RemoveDuplicates_Medium {
    /**
     * 题目：给定一个有序数组 nums ，请 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     * 思路：用一个指针 end 标识当前精简数组的最后一个元素位置，迭代过程中不断使用下一个不同数字来覆盖上一个多出来的部分；
     *
     * @param nums 含重复数字的数组
     * @return 返回精简后的数组长度
     */
    public static int removeDuplicates(int[] nums) {
        int end = 0;
        int lastNum = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == lastNum) {
                // 当前数字计数超过 2 时，则 end 不再右移
                if (++count <= 2) {
                    end++;
                }
            } else {
                // 出现新数字时进行初始化；
                lastNum = nums[i];
                count = 1;
                end++;
            }
            // 使用新的数字覆盖掉多余的重复数字；
            nums[end] = nums[i];
//            System.out.println(Arrays.toString(nums) + ", " + end);
        }
        return end + 1;
    }

    public static void main(String[] args) {
        int[] nums1 = InputStringConvert.stringToIntArray("[1,1,1,2,2,3]");
        System.out.println(removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = InputStringConvert.stringToIntArray("[0,0,1,1,1,1,2,3,3]");
        System.out.println(removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums2));
    }
}
