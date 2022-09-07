package com.sun.leetcode.No1_50;

public class No26_RmDuplicatesInSortedArray_Simple {

    /**
     * 题目：给定一个升序数组，删除其中重复元素，返回新数组的长度；
     *      不要使用额外的空间，必须在 原地 修改输入数组，并在使用 O(1) 额外空间的条件下完成。
     * 思路：从第2个元素起遍历数组，并判断当前数字是否与最新的一个去重后数组中的最后一位相同
     *      若相同的跳过；若不同则将其放在下一位
     *
     * @param nums 升序数组
     * @return 去重数组的元素个数
     */
    public int removeDuplicates(int[] nums) {
        // i为去重后数组的最后一位的下一位
        // j为整个数组遍历的索引
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;

//        TreeSet<Integer> set = new TreeSet<>();
//        Collections.addAll(set, Arrays.stream(nums).boxed().toList().toArray(new Integer[0]));
//        Iterator<Integer> itrt = set.iterator();
//        for (int i = 0; i < set.size(); i++) {
//            nums[i] = itrt.next();
//        }
//        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        No26_RmDuplicatesInSortedArray_Simple rmDupNum = new No26_RmDuplicatesInSortedArray_Simple();
        System.out.println(rmDupNum.removeDuplicates(nums));
    }
}
