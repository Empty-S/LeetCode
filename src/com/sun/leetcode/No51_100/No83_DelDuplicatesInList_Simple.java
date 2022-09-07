package com.sun.leetcode.No51_100;

import com.sun.common.ListNode;
import com.sun.util.InputStringConvert;

public class No83_DelDuplicatesInList_Simple {
    /**
     * 题目：给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次。返回 已排序的链表 。
     * 思路：使用 end 指针标记无重链表的最后一个节点，判断与下个节点值不同时，end 进行迭代
     *
     * @param head 含重复数字的链表头节点
     * @return 已剔除重复数字的链表头节点
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode end = head;
        for (ListNode idx = head; idx.next != null; idx = idx.next) {
            if (idx.val != idx.next.val) {
                end.next = idx.next;
                end = end.next;
            }
        }
        end.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(InputStringConvert.stringToIntArray("[1,1,2]"));
        System.out.println(deleteDuplicates(head1));

        ListNode head2 = new ListNode(InputStringConvert.stringToIntArray("[1,1,2,3,3]"));
        System.out.println(deleteDuplicates(head2));
    }
}
