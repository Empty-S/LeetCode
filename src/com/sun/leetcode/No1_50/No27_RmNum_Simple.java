package com.sun.leetcode.No1_50;

import java.util.Arrays;

public class No27_RmNum_Simple {
    /**
     * 题目：给定一个数组和数字，删除所有与该数字相同的元素，返回新数组的长度，元素的顺序可以改变；
     *      不要使用额外的空间，必须在 原地 修改输入数组，并在使用 O(1) 额外空间的条件下完成。
     * 思路：从头遍历数组，若不与该数字相同则迭代，若不同则从数组末尾起找一个不同的数字填充，直到两个指针相同；
     *      内存优化：i不变，j改为从前向后遍历，若值不同则写入i的位置，若相同则迭代j；
     *
     * @param nums 数组
     * @param val  要删除的数字
     * @return 返回剩余元素个数
     */
    public static int removeElement(int[] nums, int val) {
        // i为最后一个不为val的元素；
        // j为将要替换val的元素
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;

//        int i = 0;
//        int j = nums.length - 1;
//        while (i <= j) {
//            if (nums[i] != val) {
//                i++;
//                continue;
//            }
//            if (nums[j] != val) {
//                nums[i++] = nums[j];
//            }
//            j--;
//        }
//        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(removeElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }
}
