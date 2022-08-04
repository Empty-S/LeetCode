package com.sun.leetcode.No51_100;

import java.util.ArrayList;
import java.util.List;

public class No68_TextAlignment_Hard {

    /**
     * 题目：给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
     *      应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
     *      要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
     *      文本的最后一行应为左对齐，且单词之间不插入额外的空格。
     *      注意:
     *          1. 单词是指由非空格字符组成的字符序列。
     *          2. 每个单词的长度大于 0，小于等于 maxWidth。
     *          3. 输入单词数组 words 至少包含一个单词。
     * 思路：按每个单词至少间隔一个空格进行计算，确定每行有多少单词后，计算每个单词间隙应填充多少空格，对于不能均分的空格，从左向右依次填入额外 1 个空格
     *      最后一行单词间隔 1 个空格即可，末尾用空格补全至 maxWidth
     *
     * @param words 单词数组
     * @param maxWidth 每行最大字符宽度
     * @return 每行字符结果
     */
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> textSeg = new ArrayList<>();
        int textSegLen = 0;
        for (String word : words) {
            if (textSegLen == 0) {
                textSeg.add(word);
                textSegLen += word.length();
            }
            // 这里的 +1 指单词之间至少要有一个空格
            else if (textSegLen + 1 + word.length() <= maxWidth) {
                textSeg.add(word);
                textSegLen += 1 + word.length();
            }
            // 若加上当前单词已超最大宽度，则将该单词以前的片段进行处理
            else {
                // n个单词有 n-1个空隙
                int gapNum = textSeg.size() - 1;
                int fillSpaceNum = maxWidth - textSegLen;
                // 若一行仅有一个单词，则直接使用剩余空格填充，否则按平均空格 +1填充，此处 +1为单词之间至少要有的空格
                int avgSpace = gapNum == 0 ? fillSpaceNum : fillSpaceNum / gapNum + 1;
                // 若一行仅有一个单词，则没有多余空格，否则 avg剩下的空格优先从左边加
                int leftSpace = gapNum == 0 ? 0 : fillSpaceNum % gapNum;
                StringBuilder text = new StringBuilder();
                for (int i = 0; i < textSeg.size(); i++) {
                    if (i != textSeg.size() - 1 && leftSpace > 0) {
                        text.append(textSeg.get(i)).append(getNSpace(avgSpace + 1));
                        leftSpace--;
                    } else if (i != textSeg.size() - 1) {
                        text.append(textSeg.get(i)).append(getNSpace(avgSpace));
                    } else {
                        text.append(textSeg.get(i));
                    }
                    if (textSeg.size() == 1) {
                        text.append(getNSpace(fillSpaceNum));
                    }
                }
                result.add(text.toString());
                textSeg.clear();
                textSeg.add(word);
                textSegLen = word.length();
            }
        }
        // 单独对最后一行进行处理
        String lastText = String.join(" ", textSeg);
        result.add(lastText + getNSpace(maxWidth - lastText.length()));
        return result;
    }

    private static String getNSpace(int n) {
        return n == 0 ? "" : String.format("%1$" + n + "s", "");
    }

    public static void main(String[] args) {
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth1 = 16;
        System.out.println(fullJustify(words1, maxWidth1));

        String[] words2 = {"What", "must", "be", "acknowledgment", "shall", "be"};
        int maxWidth2 = 16;
        System.out.println(fullJustify(words2, maxWidth2));

        String[] words3 = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        int maxWidth3 = 20;
        System.out.println(fullJustify(words3, maxWidth3));

        String[] words4 = {"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"};
        int maxWidth4 = 16;
        System.out.println(fullJustify(words4, maxWidth4));
    }
}
