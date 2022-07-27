package com.sun.leetcode.No51_100;

import java.util.ArrayList;
import java.util.List;

public class No52_NQueensNum_Hard {
    /**
     * 题目：给你一个整数 n，返回 n皇后问题不同的解决方案的数量。
     *
     * @param n 棋盘大小
     * @return 所有可能放置方案的数量
     */
    public static int totalNQueens(int n) {
        List<Integer> result = new ArrayList<>();
        char[][] matrix = new char[n][n];
        NQueensRecurse(result, n, matrix, 0);
        return result.size();
    }

    private static void NQueensRecurse(List<Integer> result, int n, char[][] matrix, int row) {
        if (row == n) {
            result.add(1);
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
        System.out.println(totalNQueens(4));
    }
}
