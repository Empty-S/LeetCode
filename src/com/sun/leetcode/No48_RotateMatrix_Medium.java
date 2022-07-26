package com.sun.leetcode;

import java.util.Arrays;

public class No48_RotateMatrix_Medium {

    /**
     * 题目：给定一个 n × n 的二维矩阵 matrix 表示一个图像，将图像顺时针旋转 90 度。
     *      必须在 原地 旋转图像，即直接修改输入的二维矩阵，不要 使用另一个矩阵来旋转图像。
     * 思路：由于不可使用额外矩阵，因此必须将替换位置的4个节点一次循环完成
     *      因此按照有外到内 + 顺时针循环的方式，将互换位置的4个节点完成旋转
     *
     * @param matrix 矩阵
     */
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        int depth = matrix.length / 2;
        // 首先从外到内逐层循环
        for (int i = 0; i < depth; i++) {
            // 其次同层，从左上角顶点开始循环，直至右上角的前一个
            for (int j = i; j < len - 1 - i; j++) {
                int curNum = matrix[i][j];
                // 最后，交换旋转前后四个点的数值（顺时针）
                for (int k = 0; k < 4; k++) {
                    int nextI = j;
                    int nextJ = len - 1 - i;
                    int nextNum = matrix[nextI][nextJ];
                    matrix[nextI][nextJ] = curNum;
                    i = nextI;
                    j = nextJ;
                    curNum = nextNum;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
