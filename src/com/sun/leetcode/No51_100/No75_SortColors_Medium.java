package com.sun.leetcode.No51_100;

import java.util.Arrays;

import static com.sun.util.InputStringConvert.stringToIntArray;

public class No75_SortColors_Medium {
    /**
     * 题目：给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     *      使用整数 0、 1 和 2 分别表示红色、白色和蓝色,必须在不使用库的sort函数的情况下解决这个问题。
     * 思路：与快排 partition()的思想类似，将比 1 小的从前往后放，比 1 大的从后往前放，一趟扫描完成。
     *      redIdx、blueIdx 分别标记当前 0 和 2 的位置，从前向后遍历，redIdx < i < blueIdx，且可知在 i 的前面，不会出现 2（若出现则已交换至最后）
     *      因此 nums[i] = 0 时，可直接与 redIdx + 1 交换（此时 nums[redIdx+1] 只可能是 1 或 0），此时 i 可以向后迭代；
     *      而 nums[i] = 2时，不能确定 nums[blueIdx-1] 的值，因此交换后的 nums[i] 仍需进行判断处理，此时 i 不可以向后迭代；
     *
     * @param nums 待排序数组
     */
    public static void sortColors(int[] nums) {
        int redIdx = -1;
        int blueIdx = nums.length;
        for (int i = 0; i < blueIdx; ) {
            if (nums[i] == 2) {
                swap(nums, i, --blueIdx);
            } else if (nums[i] == 0) {
                swap(nums, i++, ++redIdx);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums1 = stringToIntArray("[1,0,2,1,1,0]");
        sortColors(nums1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = stringToIntArray("[2,0,1]");
        sortColors(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = stringToIntArray("[2,0,2,0]");
        sortColors(nums3);
        System.out.println(Arrays.toString(nums3));
    }
}
