package com.sun.leetcode.No51_100;

import java.util.ArrayList;
import java.util.List;

public class No54_PrintSpiralMatrix_Medium {

    /**
     * 题目：给定一个 m*n 的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * 思路：同 No48 矩阵旋转，从外到内一层一层进行遍历，同一层按照顺时针方向遍历；且通过额外数组判断当前位置是否已遍历过，防止重复遍历；
     *
     * @param matrix 要遍历的矩阵
     * @return 遍历结果
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rowNum = matrix.length;
        int halfRowNum = (int) Math.ceil(rowNum / 2.0);
        int colNum = matrix[0].length;
        int halfColNum = (int) Math.ceil(colNum / 2.0);
        int[][] flag = new int[rowNum][colNum];
        for (int i = 0; i < halfRowNum && i < halfColNum; i++) {
            // 上边框，从左向右迭代
            int row = i;
            int col = i;
            while (col < colNum - i) {
                flag[row][col] = 1;
                result.add(matrix[row][col++]);
            }
            // 右边框，从上向下迭代
            row++;
            col--;
            while (row < rowNum - i) {
                flag[row][col] = 1;
                result.add(matrix[row++][col]);
            }
            // 下边框，从右向左迭代
            row--;
            col--;
            while (col >= i && flag[row][col] == 0) {
                flag[row][col] = 1;
                result.add(matrix[row][col--]);
            }
            // 左边框，从下向上迭代
            row--;
            col++;
            while (row > i && flag[row][col] == 0) {
                flag[row][col] = 1;
                result.add(matrix[row--][col]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix1));

        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}, {16, 17, 18}};
        System.out.println(spiralOrder(matrix2));

        int[][] matrix3 = {{2, 5}, {8, 4}, {0, -1}};
        System.out.println(spiralOrder(matrix3));
    }
}
