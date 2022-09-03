package com.sun.leetcode.No51_100;

import com.sun.util.InputStringConvert;

public class No79_SearchWordInMatrix_Medium {
    /**
     * 题目：给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *      单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     *      同一个单元格内的字母不允许被重复使用。
     * 思路：从 word 的第一个字符开始判断，当前格子是否与 word 中的第 i 个字符相同，若相同则尝试该格子上下左右的字符 与 i+1 进行匹配
     * 使用 mark 标记已匹配的路径
     *
     * @param board 字符矩阵
     * @param word  目标单词
     * @return 是否存在
     */
    public static boolean exist(char[][] board, String word) {
        int rowLen = board.length;
        int colLen = board[0].length;
        // 用于标记某字符是否已被使用
        int[][] mark = new int[rowLen][colLen];
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (exists(board, word, 0, mark, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean exists(char[][] board, String word, int idx, int[][] mark, int row, int col) {
        if (idx == word.length()) {
            return true;
        }
        // 若当前位置字符与 word 中第 idx 个字符不同，则返回 false
        if (board[row][col] != word.charAt(idx)) {
            return false;
        }
        // 若相同，则在 mark 中标记，且尝试 row,col 周边位置查找下一个字符
        mark[row][col] = 1;
        if (row - 1 >= 0 && mark[row - 1][col] != 1 && exists(board, word, idx + 1, mark, row - 1, col)
                || row + 1 < board.length && mark[row + 1][col] != 1 && exists(board, word, idx + 1, mark, row + 1, col)
                || col - 1 >= 0 && mark[row][col - 1] != 1 && exists(board, word, idx + 1, mark, row, col - 1)
                || col + 1 < board[0].length && mark[row][col + 1] != 1 && exists(board, word, idx + 1, mark, row, col + 1)
                || idx == word.length() - 1 // 当最后一个字符所在格子的周围都不能使用时，则无法进入递归终止条件，因此需要额外添加一条逻辑
        ) {
            return true;
        }
        mark[row][col] = 0;
        return false;
    }

    public static void main(String[] args) {
        char[][] board1 = InputStringConvert.stringToCharMatrix("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]");
        String word1 = "ABCCED";
        System.out.println(exist(board1, word1));
        String word2 = "SEE";
        System.out.println(exist(board1, word2));
        String word3 = "ABCB";
        System.out.println(exist(board1, word3));

        char[][] board2 = InputStringConvert.stringToCharMatrix("[[\"a\"]]");
        String word4 = "a";
        System.out.println(exist(board2, word4));
    }
}
