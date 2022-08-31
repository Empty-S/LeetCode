package com.sun.leetcode.No51_100;

import java.util.Arrays;

import static com.sun.util.InputStringConvert.stringToIntMatrix;

public class No74_SearchMatrix_Medium {
    /**
     * 题目：编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     *      - 每行中的整数从左到右按升序排列。
     *      - 每行的第一个整数大于前一行的最后一个整数。
     * 思路：首先顺序遍历，判断 target 是否小于这一行的最后一个值（即改行的最大值），若是则在该行内进行二分查找；
     *
     * @param matrix 要搜索的矩阵
     * @param target 目标值
     * @return 是否存在该值
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int colLen = matrix[0].length;
        for (int[] ints : matrix) {
            if (target <= ints[colLen - 1]) {
                return Arrays.binarySearch(ints, target) >= 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix1 = stringToIntMatrix("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]");
        System.out.println(searchMatrix(matrix1, 3));

        int[][] matrix2 = stringToIntMatrix("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]");
        System.out.println(searchMatrix(matrix2, 13));
    }
}
