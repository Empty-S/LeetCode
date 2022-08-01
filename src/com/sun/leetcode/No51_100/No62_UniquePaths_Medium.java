package com.sun.leetcode.No51_100;

import static com.sun.util.PermutationAndCombination.combination;

public class No62_UniquePaths_Medium {

    /**
     * 题目：一个机器人位于一个 m x n 网格的左上角，每次只能向下或者向右移动一步，问达到网格的右下角总共有多少条不同的路径？
     * （按格子移动，而非网格交叉点）
     * 思路：排列组合问题，n, m中较大者记为 max，较小者记为 min，该问题可简化为插空 + 隔板问题，首先需要将 min-1 次的移动插入到 max-1次移动中去
     *      当 min-1 次移动全部连续时，即全部插到 max-1 次移动中的某 1 个间隙时，有 C(max, 1)个位置可选，min-1 不分组，即内部 0 个隔板；
     *      当 min-1 次移动分为 2 次时，即插到 max-1 次移动中的某 2 个间隙时，有 C(max, 2)个位置可选，min-1 分 2 组, 即内部 1 个隔板：C(min - 2, 1)；
     *      ...
     *      当 min-1 次移动分为 x 次时，即插到 max-1 次移动中的某 x 个间隙时，有 C(max, x)个位置可选，min-1 分 x 组, 即：C(min - 2, x - 1)；
     *
     * @param m 网格横向格子数
     * @param n 网格纵向格子数
     * @return 不同路径数量
     */
    public static int uniquePaths(int m, int n) {
        if (n == 1 || m == 1) {
            return 1;
        }
        int result = 0;
        int max = Math.max(m, n);
        int min = Math.min(m, n);
        for (int i = 0; i < min - 1; i++) {
            result += combination(max, i + 1) * combination(min - 2, i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(1, 2));
    }
}
