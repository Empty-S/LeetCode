package com.sun.leetcode.No51_100;

import com.sun.util.InputStringConvert;

import static com.sun.leetcode.No51_100.No84_LargestRectangleArea_Hard.largestRectangleArea;

public class No85_MaximalRectangle_Hard {
    /**
     * 题目：给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     * 思路：首先将二维数组退化为一维数组，然后使用 No.84 中最大矩形面积算法求解；
     *      退化维度方法：从 0 ~ rowLen-1 进行迭代，对第 i 行来说，0~i 行的同一列的格子看作柱子，
     *          matrix[i][j] 为 0 ，则柱子高度也为 0；否则，柱子高度为上一行柱子高度 + 1（即该列与上一个 0（或第0行） 之间有多少个 1）
     *
     * @param matrix 矩阵
     * @return 最大面积
     */
    public static int maximalRectangle(char[][] matrix) {
        int colLen = matrix[0].length;
        int maxArea = 0;
        int[] sum = new int[colLen];
        for (char[] chars : matrix) {
            for (int j = 0; j < colLen; j++) {
                sum[j] = chars[j] == '0' ? 0 : sum[j] + 1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(sum));
        }
        return maxArea;
    }

//    // 暴力循环，能解但性能不好
//    public static int maximalRectangle(char[][] matrix) {
//        int rowLen = matrix.length;
//        int colLen = matrix[0].length;
//        int maxArea = 0;
//        for (int i = 0; i < rowLen; i++) {
//            for (int j = 0; j < colLen; j++) {
//                if (matrix[i][j] == '1') {
//                    maxArea = Math.max(maxArea, findMaxArea(matrix, i, j));
//                }
//            }
//        }
//        return maxArea;
//    }
//
//    private static int findMaxArea(char[][] matrix, int startRow, int startCol) {
//        int rowLen = matrix.length;
//        int colLen = matrix[0].length;
//        int maxArea = 0;
//        int endCol = colLen;
//        for (int i = startRow; i < rowLen; i++) {
//            if (matrix[i][startCol] == '0') {
//                break;
//            }
//            for (int j = startCol; j < endCol; j++) {
//                if (matrix[i][j] == '0') {
//                    endCol = j;
//                    break;
//                }
//            }
//            maxArea = Math.max(maxArea, (i - startRow + 1) * (endCol - startCol));
//        }
//        return maxArea;
//    }

    public static void main(String[] args) {
        char[][] matrix1 = InputStringConvert.stringToCharMatrix("[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]");
        System.out.println(maximalRectangle(matrix1));

        char[][] matrix2 = InputStringConvert.stringToCharMatrix("[]");
        System.out.println(maximalRectangle(matrix2));

        char[][] matrix3 = InputStringConvert.stringToCharMatrix("[[\"0\"]]");
        System.out.println(maximalRectangle(matrix3));

        char[][] matrix4 = InputStringConvert.stringToCharMatrix("[[\"1\"]]");
        System.out.println(maximalRectangle(matrix4));

        char[][] matrix5 = InputStringConvert.stringToCharMatrix("[[\"0\",\"0\"]]");
        System.out.println(maximalRectangle(matrix5));
    }
}
