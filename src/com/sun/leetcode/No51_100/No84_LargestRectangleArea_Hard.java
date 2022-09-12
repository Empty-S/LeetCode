package com.sun.leetcode.No51_100;

import com.sun.util.InputStringConvert;

import java.util.Stack;

public class No84_LargestRectangleArea_Hard {
    /**
     * 题目：给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。求在该柱状图中，能够勾勒出来的矩形的最大面积。
     * 思路：与 No42接雨水思路较为相近，对于第 i 个柱子来说，能完全覆盖它的矩形有以下特点：
     *          1.矩形的高与柱子 i 高度相同；
     *          2.矩形内的柱子高度均 >= 柱子 i 的高度（即矩形外左右两边柱子高度均 < 柱子 i）
     *      暴力解法为：从柱子 i 向左右两边分别迭代，遇到高度 < height[i]的柱子就停止，此时可得矩形的宽，该方法时间复杂度为 O(n^2)
     *      使用单调栈：若柱子 i 的高度 >= 栈顶柱子的高度，即意味着栈顶柱子的右边界仍未出现；
     *                  反之，则 i 即为栈顶柱子的右边界（不含在矩形内），由于栈中元素单调递增，则栈顶柱子之下的柱子所在位置即为矩形左边界（不含在矩形内）
     *                  因此，矩形面积为 height[stack.pop()] * (i - (stack.top() + 1))。
     *                  此时需注意，若栈顶柱子之下无其他柱子，则意味着栈顶柱子是 [0, i-1] 内最矮的柱子，其面积为 height[stack.pop()] * i
     *                  单调栈的典型场景：在一维数组中，找到第一个满足某种条件的数
     *
     * @param heights 各柱子高度
     * @return 最大矩形面积
     */
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> incStack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            // 模拟最后一位插入 0，便于在最后时清空 stack
            int curHeight = i == heights.length ? 0 : heights[i];
            while (!incStack.isEmpty() && curHeight < heights[incStack.peek()]) {
                int height = heights[incStack.pop()];
                int width = incStack.isEmpty() ? i : i - (incStack.peek() + 1);
                maxArea = Math.max(maxArea, height * width);
            }
            incStack.push(i);
        }
        return maxArea;
    }

//    // 超时
//    public static int largestRectangleArea(int[] heights) {
//        int len = heights.length;
//        int maxArea = 0;
//        // i 代表区间起始位置，j 代表区间长度
//        for (int i = 0; i < len; i++) {
//            int minHeight = heights[i];
//            for (int j = 1; j <= len - i; j++) {
//                minHeight = Math.min(minHeight, heights[i + j - 1]);
//                maxArea = Math.max(maxArea, j * minHeight);
//            }
//        }
//        return maxArea;
//    }

    public static void main(String[] args) {
        int[] heights1 = InputStringConvert.stringToIntArray("[2,1,5,6,2,3]"); // 10
        System.out.println(largestRectangleArea(heights1));

        int[] heights2 = InputStringConvert.stringToIntArray("[2,4]"); // 4
        System.out.println(largestRectangleArea(heights2));

        int[] heights3 = InputStringConvert.stringToIntArray("[0]"); // 0
        System.out.println(largestRectangleArea(heights3));

        int[] heights4 = InputStringConvert.stringToIntArray("[1,2,2]"); // 4
        System.out.println(largestRectangleArea(heights4));

        int[] heights5 = InputStringConvert.stringToIntArray("[0,9]");  // 9
        System.out.println(largestRectangleArea(heights5));

        int[] heights6 = InputStringConvert.stringToIntArray("[7,6,0,9]");  // 12
        System.out.println(largestRectangleArea(heights6));

        int[] heights7 = InputStringConvert.stringToIntArray("[999,999,999,999]"); // 3996
        System.out.println(largestRectangleArea(heights7));

        int[] heights8 = InputStringConvert.stringToIntArray("[0,1,0,2,1,0,1,3,2,1,2,1]");  // 6
        System.out.println(largestRectangleArea(heights8));
    }
}
