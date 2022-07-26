package com.sun.leetcode;

import java.util.*;

public class No49_GroupAnagrams_Medium {

    /**
     * 题目：给定一个字符串数组，请将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     *      字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常 恰好只用一次 。
     * 思路：即 只要字符串中各字母出现次数相同的，即可认为是同一字母异位词
     *
     * @param strs 字符串数组
     * @return 相同的字母异位词放在同一个List中
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = Arrays.toString(charArr);
            List<String> value = map.putIfAbsent(key, new ArrayList<>());
            if (null == value) {
                value = map.get(key);
            }
            value.add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
