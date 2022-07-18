package com.sun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class No37_SolveSudoku_Hard {
    /**
     * 题目：编写一个程序，通过填充空格来解决数独问题，空格用 '.' 来表示，题目数据保证输入数独仅有一个解
     * 思路：初始化，每行每列每块的数字均存入 Set，共 27个；
     *      遍历所有空格子，尝试用 1~9 填充，每次填充判断行列块中是否已有该数字：若有则跳过，若没有则将其填入该格子，并将数字加入对应 Set ；
     *      以当前形态的 board 向下递归（从当前行列开始），直至找到唯一解；若递归后的结果找不到解，则将该数字从当前格子抹除，同时在 Set 中剔除。
     *
     * @param board 初始数独
     */
    public static void solveSudoku(char[][] board) {
        List<HashSet<Character>> rowSetList = new ArrayList<>();
        List<HashSet<Character>> colSetList = new ArrayList<>();
        List<HashSet<Character>> blockSetList = new ArrayList<>();
        init(board, rowSetList, colSetList, blockSetList);
        solveSudokuRecurse(board, rowSetList, colSetList, blockSetList, 0, 0);
    }

    private static void init(char[][] board, List<HashSet<Character>> rowSetList,
                             List<HashSet<Character>> colSetList, List<HashSet<Character>> blockSetList) {
        for (int i = 0; i < board.length; i++) {
            rowSetList.add(new HashSet<>());
            colSetList.add(new HashSet<>());
            blockSetList.add(new HashSet<>());
        }
        for (int i = 0; i < board.length; i++) { // 行遍历
            HashSet<Character> rowSet = rowSetList.get(i);
            for (int j = 0; j < board[i].length; j++) { // 列遍历
                if (board[i][j] == '.') {
                    continue;
                }
                char num = board[i][j];
                HashSet<Character> colSet = colSetList.get(j);
                HashSet<Character> blockSet = blockSetList.get(i / 3 * 3 + j / 3);
                rowSet.add(num);
                colSet.add(num);
                blockSet.add(num);
            }
        }
    }

    private static boolean solveSudokuRecurse(char[][] board, List<HashSet<Character>> rowSetList,
                                              List<HashSet<Character>> colSetList, List<HashSet<Character>> blockSetList,
                                              int rowIdx, int colIdx) {
        for (int i = rowIdx; i < board.length; i++) { // 行遍历
            HashSet<Character> rowSet = rowSetList.get(i);
            for (int j = i == rowIdx ? colIdx : 0; j < board[i].length; j++) { // 列遍历
                if (board[i][j] != '.') {
                    continue;
                }
                HashSet<Character> colSet = colSetList.get(j);
                HashSet<Character> blockSet = blockSetList.get(i / 3 * 3 + j / 3);
                for (char k = '1'; k <= '9'; k++) {
                    if (!rowSet.contains(k) && !colSet.contains(k) && !blockSet.contains(k)) {
                        board[i][j] = k;
                        rowSet.add(k);
                        colSet.add(k);
                        blockSet.add(k);
                        if (solveSudokuRecurse(board, rowSetList, colSetList, blockSetList, i, j)) {
                            return true;
                        } else {
                            board[i][j] = '.';
                            rowSet.remove(k);
                            colSet.remove(k);
                            blockSet.remove(k);
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }
}
