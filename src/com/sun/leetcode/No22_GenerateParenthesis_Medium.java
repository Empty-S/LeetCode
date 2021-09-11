package com.sun.leetcode;

import java.util.LinkedList;
import java.util.List;

public class No22_GenerateParenthesis_Medium {


    /**
     * 题目：数字 n 代表生成括号的对数，生成所有可能且有效的括号组合
     * 思路：用递归来生成括号组合，用left/right数字代表剩余左右括号个数
     *
     * @param n 生成括号的对数
     * @return 所有可能且有效的括号组合
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        if (n > 0) {
            // 第一个一定为左括号
            generateParenthesis(result, new StringBuilder("("), n - 1, n);
        }
        return result;
    }

    /**
     * 用递归不断追加括号，直到左右括号均使用完
     *
     * @param result 结果List
     * @param sb 括号组合
     * @param left 左括号剩余个数
     * @param right 右括号剩余个数
     */
    private void generateParenthesis(List<String> result, StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
        }
        // 下一个括号既可以为左括号，也可以为右括号，但为右括号时有限制条件
        // 只要左括号有剩余，便可一直用
        if (left > 0) {
            generateParenthesis(result, sb.append("("), left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        // 使用的左括号一定比右括号多（即剩余的左括号比右括号少），不然会出现无效括号匹配的情况
        if (right > 0 && left < right) {
            generateParenthesis(result, sb.append(")"), left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        No22_GenerateParenthesis_Medium solution = new No22_GenerateParenthesis_Medium();
        System.out.println(solution.generateParenthesis(3));
        System.out.println(solution.generateParenthesis(8).size());
    }
}
