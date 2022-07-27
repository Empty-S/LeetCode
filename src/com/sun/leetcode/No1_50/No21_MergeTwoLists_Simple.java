package com.sun.leetcode.No1_50;

import com.sun.common.ListNode;

public class No21_MergeTwoLists_Simple {
    /**
     * 题目：将两个升序链表合并为一个新的 升序 链表并返回。
     * 思路：循环两个链表，并修改节点next指向，不新建节点，节省内存
     *
     * @param l1 非递减链表1
     * @param l2 非递减链表2
     * @return 合并后的链表头结点
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode idx = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                idx.next = l1;
                l1 = l1.next;
            } else {
                idx.next = l2;
                l2 = l2.next;
            }
            idx = idx.next;
        }
        idx.next = null == l1 ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {

    }
}