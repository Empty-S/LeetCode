package com.sun.leetcode.No1_50;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class No36_ValidSudoku_Medium {
    /**
     * 题目：请判断一个 9 x 9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     *      1. 数字 1-9 在每一行只能出现一次。
     *      2. 数字 1-9 在每一列只能出现一次。
     *      3. 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * 思路：每行每列每块的数字均存下来，遍历所有格子判断是否存在重复数字
     *
     * @param board 数独格子
     * @return 是否有效
     */
    public static boolean isValidSudoku(char[][] board) {
        List<HashSet<Integer>> rowSetList = new ArrayList<>();
        List<HashSet<Integer>> colSetList = new ArrayList<>();
        List<HashSet<Integer>> blockSetList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            rowSetList.add(new HashSet<>());
            colSetList.add(new HashSet<>());
            blockSetList.add(new HashSet<>());
        }
        for (int i = 0; i < board.length; i++) { // 行遍历
            HashSet<Integer> rowSet = rowSetList.get(i);
            for (int j = 0; j < board[i].length; j++) { // 列遍历
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j];
                HashSet<Integer> colSet = colSetList.get(j);
                HashSet<Integer> blockSet = blockSetList.get(i / 3 * 3 + j / 3);
                if (rowSet.contains(num) || colSet.contains(num) || blockSet.contains(num)) {
                    return false;
                } else {
                    rowSet.add(num);
                    colSet.add(num);
                    blockSet.add(num);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'8','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }
}
