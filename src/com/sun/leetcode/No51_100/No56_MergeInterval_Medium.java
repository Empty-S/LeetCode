package com.sun.leetcode.No51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class No56_MergeInterval_Medium {

    /**
     * 题目：以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     *      请合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     * 思路：首先将区间按左区间进行升序排列，随后从下标1开始遍历，若当前区间的左边界 <= 上一个区间的右边界，即包含在上衣区间内，
     *      则合并两区间，若两区间无重叠，则将上一个区间加入到结果集。注意最后一个区间要在循环外添加。
     *
     * @param intervals 若干区间的集合
     * @return 不重叠的区间数组
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));
//        System.out.println(Arrays.deepToString(intervals));
        List<int[]> resultList = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] >= intervals[i][0]) {
                intervals[i][0] = Math.min(intervals[i - 1][0], intervals[i][0]);
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
            } else {
                resultList.add(intervals[i - 1]);
            }
        }
        resultList.add(intervals[intervals.length - 1]);
        int[][] result = new int[resultList.size()][2];
        return resultList.toArray(result);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals1)));

        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println(Arrays.deepToString(merge(intervals2)));

        int[][] intervals3 = {{1, 7}, {2, 6}, {5, 8}, {15, 18}, {8, 10}};
        System.out.println(Arrays.deepToString(merge(intervals3)));
    }
}
