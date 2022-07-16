package com.sun.leetcode;

import java.util.Arrays;

public class No31_NextPermutation_Medium {
    /**
     * 题目：给定一个整数数组 nums ，找出 nums 的下一个排列
     *      整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
     *      更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
     *      如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     * 思路：从数组最后一位向前迭代，寻找 nums[i+1] > nums[i] 的位置，即当前数字小于后一位数字的位置
     *      从该位置往后的所有数字需重新排列，首先将这些数字正序排列，将比 nums[i]大的第一个数字放到第一位即可
     *      例：1527642，找到27，即27642需重新排列，正序为22467，将4放到最前面，即42267，最终结果为1542267
     *      特殊情况，若找不到，则直接返回正序数组
     *
     * @param nums 当前排列
     */
    public static void nextPermutation(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                // 从后往前正序的一个对位置
                int ithNum = nums[i];
                // 将 i 往后的数字排序
                Arrays.sort(nums, i, nums.length);
                // 找到排序后 ithNum 的位置
                int idx = Arrays.binarySearch(nums, i, nums.length, ithNum);
                // 记录比 ithNum大的第一个数字
                while (idx < nums.length - 1 && ithNum >= nums[++idx]) {
                }
                int next = nums[idx];
                // 将这个数字放到i的位置，其余数字后移
                System.arraycopy(nums, i, nums, i + 1, idx - i);
                nums[i] = next;
                return;
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 2, 7, 6, 4, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
