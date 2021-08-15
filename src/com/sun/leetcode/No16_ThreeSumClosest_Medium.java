package com.sun.leetcode;

public class No16_ThreeSumClosest_Medium {
    public static int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < minDiff) {
                        minDiff = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        sum = nums[i] + nums[j] + nums[k];
                    }
//                    System.out.println(nums[i] + ", " + nums[j] + ", " + nums[k]);
//                    System.out.println("minDiff: " + minDiff);
//                    System.out.println("sum: " + sum);
//                    System.out.println();
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 16, 32, 64, 128};
        int target = 82;
        System.out.println(threeSumClosest(nums, target));
    }
}
