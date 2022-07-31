package com.sun.leetcode.No51_100;

public class No58_LengthOfLastWord_Simple {

    /**
     * 题目：给定一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
     *      单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     *
     * @param s 字符串
     * @return 最大长度
     */
    public static int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }
}
