package com.sun.leetcode;

public class No38_OutwardSequence_Medium {

    /**
     * 题目：给定一个正整数 n ，输出外观数列的第 n 项。
     *      「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。将其视作是由递归公式定义的数字字符串序列：
     *      countAndSay(1) = "1"，第一项是数字 1
     *      countAndSay(2) = "11"，描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
     *      countAndSay(3) = "21"，描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
     *      countAndSay(4) = "1211"，描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
     *      countAndSay(5) = "111221"，描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
     *      countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
     * 思路：第 n 项即 n 次循环，每次循环结果作为下次的输入，不断迭代；
     *      每次循环，从第2位字符开始，比较其与前一个字符是否相同，相同则 count++，不同则重置count；
     *
     * @param n 外观数列的第 n 项
     * @return 第 n 项外观数列
     */
    public static String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            char last = result.charAt(0);
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) != last) {
                    sb.append(count).append(last);
                    count = 1;
                } else {
                    count++;
                }
                last = result.charAt(j);
            }
            if (0 != count) {
                sb.append(count).append(result.charAt(result.length() - 1));
            }
            result = sb.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }
}
