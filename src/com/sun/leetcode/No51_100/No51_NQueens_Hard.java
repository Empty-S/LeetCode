package com.sun.leetcode.No51_100;

import java.util.ArrayList;
import java.util.List;

public class No51_NQueens_Hard {
    /**
     * 题目：按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
     *      n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     *      给你一个整数 n，返回所有不同的 n皇后问题的解决方案。
     *      每一种解法包含一个不同的 n皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * 思路：从第 0 行起，遍历每一列，判断当前位置是否可以放置 Q（即，同列、右上对角线、左上对角线是否已有 Q）
     *      若没有，则放置 Q，并向下递归，若有，则尝试下一列
     * 优化思路：空间换时间，分别用长度为 n, 2n-2, 2n-2的一维数组，用于标记某列、右上角、左上角是否已有 Q
     *
     * @param n 棋盘大小
     * @return 所有可能的放置方案
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] matrix = new char[n][n];
        NQueensRecurse(result, n, matrix, 0);
        return result;
    }

    private static void NQueensRecurse(List<List<String>> result, int n, char[][] matrix, int row) {
        if (row == n) {
            List<String> tmp = new ArrayList<>();
            for (char[] charArr : matrix) {
                tmp.add(String.copyValueOf(charArr).replace("\u0000", "."));
            }
            result.add(tmp);
        }
        // 从第 row 行的第 0 列开始，判断当前位置是否可以放置 Q
        for (int col = 0; col < n; col++) {
            // 判断同列是否已有 Q
            boolean validCol = true;
            for (int i = 0; i < row; i++) {
                if (matrix[i][col] == 'Q') {
                    validCol = false;
                    break;
                }
            }
            // 判断 ↗ 方向是否已有 Q
            boolean validRU = true;
            for (int i = 1; row - i >= 0 && col + i < n; i++) {
                if (matrix[row - i][col + i] == 'Q') {
                    validRU = false;
                    break;
                }
            }
            // 判断 ↖ 方向是否已有 Q
            boolean validLU = true;
            for (int i = 1; row - i >= 0 && col - i >= 0; i++) {
                if (matrix[row - i][col - i] == 'Q') {
                    validLU = false;
                    break;
                }
            }
            if (validCol && validRU && validLU) {
                matrix[row][col] = 'Q';
                NQueensRecurse(result, n, matrix, row + 1);
                matrix[row][col] = '.';
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
