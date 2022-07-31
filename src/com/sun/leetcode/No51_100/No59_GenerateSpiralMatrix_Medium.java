package com.sun.leetcode.No51_100;

import java.util.Arrays;

public class No59_GenerateSpiralMatrix_Medium {

    /**
     * 题目：给定一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     * 思路：从数字 1 ~ n^2迭代，按照从外到内、且顺时针的方向（左上角开始）填充数字，若当前位置已有数字则结束当前 边 的填充。
     *
     * @param n 矩阵边长
     * @return 螺旋矩阵
     */
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int row = -1, col = -1;
        for (int i = 1; i <= n * n; ) {
            row++;
            col++;
            while (col < n && result[row][col] == 0) {
                result[row][col++] = i++;
            }
            row++;
            col--;
            while (row < n && result[row][col] == 0) {
                result[row++][col] = i++;
            }
            row--;
            col--;
            while (col >= 0 && result[row][col] == 0) {
                result[row][col--] = i++;
            }
            row--;
            col++;
            while (row >= 0 && result[row][col] == 0) {
                result[row--][col] = i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(1)));

        System.out.println(Arrays.deepToString(generateMatrix(7)));

        System.out.println(Arrays.deepToString(generateMatrix(20)));
    }
}
