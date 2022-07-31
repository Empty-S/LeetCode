package com.sun.leetcode.No51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class No57_InsertInterval_Medium {

    /**
     * 题目：给定一个 无重叠的 ，按照区间起始端点排序的区间列表。在列表中插入一个新的区间，需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     * 思路：将两个区间合并，再调用 No56 题中的 Merge()方法
     *
     * @param intervals   无重叠区间列表
     * @param newInterval 新插入的区间
     * @return 返回插入后的结果
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = Arrays.copyOf(intervals, intervals.length + 1);
        newIntervals[intervals.length] = newInterval;
//        System.out.println(Arrays.deepToString(newIntervals));
        return merge(newIntervals);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));
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

        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        System.out.println(Arrays.deepToString(insert(intervals1, newInterval1)));

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        System.out.println(Arrays.deepToString(insert(intervals2, newInterval2)));

        int[][] intervals3 = {};
        int[] newInterval3 = {5, 7};
        System.out.println(Arrays.deepToString(insert(intervals3, newInterval3)));
    }
}
