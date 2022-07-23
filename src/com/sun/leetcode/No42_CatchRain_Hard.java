package com.sun.leetcode;

public class No42_CatchRain_Hard {

    /**
     * 题目：给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * 思路：找打每个水坑的边界，以此计算每个水坑的容量
     *      1. 左起第一个高度不为 0 的柱子作为第一个水坑的左边界
     *      2. 左边界的下一个的高度要小于左边界，否则左边界右移
     *      3. 除左边界的下一个柱子外的，高度最大（不为 0）的第一个柱子 或 比左边界高的第一个柱子 为右边界
     *      4. 此时可以计算这个水坑的容量
     *      5. 随后将右边界作为左边界进行迭代
     *
     * @param height 每个柱子的高度
     * @return 能盛水的容量
     */
    public static int trap(int[] height) {
        int result = 0;
        int left = -1;
        int right = -1;
        int minBound;
        for (int i = 0; i < height.length; i++) {
            // 找到左边界：左起第一个高度不为 0 的柱子作为第一个水坑的左边界
            if (left == -1) {
                if (height[i] != 0) {
                    left = i;
                }
                continue;
            }
            // 左边界的下一个的高度要小于左边界，否则左边界右移
            if (i == left + 1 && height[left] <= height[i]) {
                left = i;
                continue;
            }
            // 找到右边界：除左边界的下一个柱子外的，高度最大（不为 0）的第一个柱子 或 比左边界高的第一个柱子 为右边界
            int maxHeight = 0;
            for (int j = i; j < height.length; j++) {
                maxHeight = Math.max(height[j], maxHeight);
            }
            // 按左边界高度为准预估水坑容量，待找到有边界后再计算准确容量
            int tmpResult = 0;
            for (int j = i; j < height.length; j++) {
                tmpResult += (left - height[j]);
                if (height[j] > height[left] || height[j] == maxHeight) {
                    right = j;
                    minBound = Math.min(height[left], height[right]);
                    tmpResult -= (left - height[j]); // 仅计算左右边界之间的容量，减掉多计入的一次
                    tmpResult -= (left - minBound) * (j - i); // 若左边界比右边界高，则需减掉多计入的容量
                    break;
                }
            }
            if (right == -1) {
                return result;
            }
            // 计算当前水坑的容量
            result += tmpResult;
            i = right;
//            System.out.println("left = " + left + ", right = " + right + ", minBound = " + minBound + ", result = " + result);
            // 将右边界作为下一个水坑的左边界进行迭代
            left = right;
            right = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height1));

        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(height2));
    }
}
