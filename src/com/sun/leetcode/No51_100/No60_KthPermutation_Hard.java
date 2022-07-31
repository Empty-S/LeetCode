package com.sun.leetcode.No51_100;

public class No60_KthPermutation_Hard {

    private static final int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    /**
     * 题目：给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列，按大小顺序列出所有排列情况，返回第 k 个排列。
     * 思路：通过观察可知，n! 的排列，可按第一位数字分为 (n-1)! 组，因此使用 k/(n-1)!可找到第一位数字在第 x 组（而第 x 组所代表的数字为 1~n中，第x个还未被使用的数字）
     * 以此类推，第二位数字使用 k%(n-1)! 的结果作为 k，n-1作为n，依然可分为 (n-1)! 组，因此使用 新的k/(n-1)!可找到第二位数字在第 x 组
     * 当 k%(n-1)! = 0时，代表第k个数字是相同的前缀下的最后一组，因此将剩余可选数字逆序排列即可
     *
     * @param n 集合元素数量
     * @param k 第 k 个排列
     * @return 第 k 个排列的值
     */
    public static String getPermutation(int n, int k) {
        // 用于标记当前数字是否已被使用
        boolean[] flag = new boolean[n];
        StringBuilder sb = new StringBuilder();
        while (k > 0) {
            // k/(n-1)!的商代表当前数字在第 x 组
            int x = (int) Math.ceil(1.0 * k / factorial[n - 1]);
            // 第 x 组所代表的数字为 1~n中，第 x 个还未被使用的数字
            for (int i = 0, cnt = 0; i < flag.length; i++) {
                if (flag[i]) {
                    continue;
                }
                cnt++;
                if (cnt == x) {
                    sb.append(i + 1);
                    flag[i] = true;
                    break;
                }
            }
            // k/(n-1)!的余数用于下一个迭代的k
            k = k % factorial[n - 1];
            n--;
        }
        // 将剩余数字逆序排列
        for (int i = flag.length - 1; i >= 0; i--) {
            if (!flag[i]) {
                sb.append(i + 1);
            }
        }
        return sb.toString();
    }

//    // 下面的版本更易理解
//    public String getPermutation(int n, int k) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(i + 1);
//        }
//        StringBuilder sb = new StringBuilder();
//        while (k > 0) {
//            int x = (int) Math.ceil(1.0 * k / factorial[n - 1]);
//            int reminder = k % factorial[n - 1];
//            sb.append(list.get(x - 1));
//            list.remove(x - 1);
//            n--;
//            k = reminder;
//        }
//        for (int i = list.size() - 1; i >= 0; i--) {
//            sb.append(list.get(i));
//        }
//        return sb.toString();
//    }

    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(4, 9));
    }
}
