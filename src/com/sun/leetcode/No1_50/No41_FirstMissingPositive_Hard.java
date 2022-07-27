package com.sun.leetcode.No1_50;

public class No41_FirstMissingPositive_Hard {

    /**
     * 题目：给定一个未排序的整数数组 nums ，找出其中没有出现的最小的正整数。
     *      要求时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     * 思路：借助额外数组，将每个 num 放在对应下标的位置，随后找到没有 num 的位置即可；
     *      即：将数组中的每个在 1 ~ len 的数字（不在范围内的丢弃），放到新数组对应下标的位置，并记为 1；
     *      随后遍历新数组，不为 1的记为最小正整数，若遍历结束，则返回新数组长度。
     *
     *      不在范围内数字丢弃的逻辑：将 num 排列在数轴上，从 1 起，取长度为 len 的窗口，
     *      若所有元素均在窗口内（此时最小正整数为 len+1），否则必然存在空位，因此无需关注窗口外的 num；
     *
     * 优化：无需额外申请空间，在原数组上操作即可；
     *
     * @param nums 无序数组
     * @return 最小正整数
     */
    public static int firstMissingPositive(int[] nums) {
        int[] position = new int[nums.length];
        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                position[num - 1] = 1;
            }

        }
        for (int i = 0; i < position.length; i++) {
            if (position[i] != 1) {
                return i + 1;
            }
        }
        return position.length + 1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 0};
        System.out.println(firstMissingPositive(nums1));

        int[] nums2 = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums2));

        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(nums3));

        int[] nums4 = {0};
        System.out.println(firstMissingPositive(nums4));

        int[] nums5 = {1, 3, 3};
        System.out.println(firstMissingPositive(nums5));

        int[] nums6 = new int[500000];
        for (int i = 0; i < 500000; i++) {
            nums6[i] = i + 1;
        }
        System.out.println(firstMissingPositive(nums6));

        int[] nums7 = new int[500000];
        for (int i = 0; i < 500000; i++) {
            if (i < 200000) {
                nums7[i] = i + 1;
            } else {
                nums7[i] = i + 2;
            }
        }
        System.out.println(firstMissingPositive(nums7));
    }
}
