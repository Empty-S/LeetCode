package com.sun.leetcode;

import java.util.*;

public class No17_LetterCombinations_Medium {

    private final String[] digitLetterList = {"", "!@#", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private final List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (null == digits || 0 == digits.length()) {
            return new ArrayList<>();
        }
        letterCombinations(digits, 0, new StringBuilder());
        return result;
    }

    /**
     * 用递归实现不确定深度的嵌套循环
     *
     * @param digits 数字组合的字符串
     * @param idx    递归模拟嵌套循环的索引
     * @param sb     构造的字符串，作用类似于Stack
     */
    private void letterCombinations(String digits, int idx, StringBuilder sb) {
        if (idx == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String str = digitLetterList[digits.charAt(idx) - '0'];
        for (int i = 0; i < str.length(); i++) {
            letterCombinations(digits, idx + 1, sb.append(str.charAt(i)));
            // 退出递归时，pop刚刚push的字符
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        No17_LetterCombinations_Medium solution = new No17_LetterCombinations_Medium();
        System.out.println(solution.letterCombinations("23"));
    }

}
