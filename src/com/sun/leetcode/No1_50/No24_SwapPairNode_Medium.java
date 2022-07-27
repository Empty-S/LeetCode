package com.sun.leetcode.No1_50;

import com.sun.common.ListNode;

public class No24_SwapPairNode_Medium {
    /**
     * 题目：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 思路：相邻节点对互相交换后，其上一个节点的next指针也需要替换
     *
     * @param head 链表
     * @return 合并后的链表头结点
     */
    public ListNode swapPairs(ListNode head) {
        ListNode first = head;
        ListNode second;
        ListNode previous = null;
        while (first != null && first.next != null) {
            second = first.next;
            // 指针交换
            first.next = second.next;
            second.next = first;
            if (null == previous) {
                head = second;
            } else {
                previous.next = second;
            }
            // 指针迭代
            previous = first;
            first = first.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
