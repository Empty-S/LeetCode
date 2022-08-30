package com.sun.leetcode.No51_100;

import java.util.Arrays;

import static com.sun.util.InputStringConvert.stringToIntMatrix;

public class No73_SetZeros_Medium {

    /**
     * 题目：给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     * 思路：使用两个数组分别标记 0 所在的行和列，随后双重循环，只要 i 或 j 与 0 所在的行列相同，则置 0；
     * 优化思路：使用常量空间，使用第一行和第一列替代上述思路中的额外数组（由于0所在的行列均需置0，因此用第一行/列标记不会影响结果），
     *          并标记第一行和第一列本身是否存在 0；若第一行/列存在0，则额外将其置0。
     *
     * @param matrix 原始矩阵
     */
    public static void setZeroes(int[][] matrix) {
        int[] rowMark = new int[matrix.length];
        int[] colMark = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowMark[i] = 1;
                    colMark[j] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowMark[i] == 1 || colMark[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void setZeroesImproved(int[][] matrix) {
        // 用来判断第一行和第一列本身是否包含0
        boolean fstRow = false;
        boolean fstCol = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        fstRow = true;
                    }
                    if (j == 0) {
                        fstCol = true;
                    }
                    // 用第一行和第一列替代 rowMark、colMark
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 若第一行第一列本身含 0，则置 0
        if (fstRow) {
            Arrays.fill(matrix[0], 0);
        }
        if (fstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix2);
        System.out.println(Arrays.deepToString(matrix2));

        int[][] matrix3 = stringToIntMatrix("[[1,2,3,4],[5,0,7,8],[0,10,11,12],[13,14,15,0]]");
        setZeroes(matrix3);
        System.out.println(Arrays.deepToString(matrix3));
    }
}
