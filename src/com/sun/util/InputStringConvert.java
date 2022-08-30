package com.sun.util;

import java.util.Arrays;

public class InputStringConvert {

    public static int[][] stringToIntMatrix(String str) {
        String[] row = str.split("],\\[");
        int colLen = row[0].split(",").length;
        int[][] matrix = new int[row.length][colLen];
        for (int i = 0; i< row.length; i++) {
            String[] col = row[i].split(",");
            for(int j = 0; j< colLen; j++) {
                matrix[i][j] = Integer.parseInt(col[j].replaceAll("\\[", "").replaceAll("]", ""));
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(stringToIntMatrix("[[1,2,3,4],[5,0,7,8],[0,10,11,12],[13,14,15,0]]")));
    }
}
