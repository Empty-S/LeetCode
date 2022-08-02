package com.sun.leetcode.No51_100;

public class No63_UniquePathsWithObstacles_Medium {

    /**
     * 题目：一个机器人位于一个 m x n 网格的左上角，每次只能向下或者向右移动一步，机器人试图达到网格的右下角
     *      现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？网格中的障碍物和空位置分别用 1 和 0 来表示。
     * 思路：No62中排列组合的思路无法使用，因此使用动态规划的思路
     *      达到第 [i,j] 个格子的可能情况有两种，从上方或左侧而来，即 dp[i][j] = dp[i-1][j] + dp[i][j-1]
     *          当 [i,j] 为障碍物时，该位置不可到达，即 dp[i][j] = 0
     *      对于 [i,0] 或 [0,j] 来说，仅有一种移动可能的来源方向，即上方或左侧，
     *          且当 [i,0] 或 [0,j] 为障碍物时，其下方或右侧的所有格子均不可到达
     *
     * @param obstacleGrid 含障碍物标识的网格
     * @return 不同路径数量
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        boolean flag = false;
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] != 1 && !flag) {
                dp[i][0] = 1;
            } else {
                flag = true;
            }
        }
        flag = false;
        for (int j = 0; j < col; j++) {
            if (obstacleGrid[0][j] != 1 && !flag) {
                dp[0][j] = 1;
            } else {
                flag = true;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid1));

        int[][] obstacleGrid2 = {{0, 1}, {0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid2));

        int[][] obstacleGrid3 = {{1}, {0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid3));

        int[][] obstacleGrid4 = {{0, 1}, {1, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid4));

        int[][] obstacleGrid5 = {{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid5));

        int[][] obstacleGrid6 = {{0, 0}, {1, 1}, {0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid6));
    }

}
