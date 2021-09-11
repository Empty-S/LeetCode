package com.sun.leetcode;

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
        ListNode head = null;
        ListNode idx = null;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (null == idx) {
                    idx = l1;
                    head = idx;
                } else {
                    idx.next = l1;
                    idx = idx.next;
                }
                l1 = l1.next;
            } else {
                if (null == idx) {
                    idx = l2;
                    head = idx;
                } else {
                    idx.next = l2;
                    idx = idx.next;
                }
                l2 = l2.next;
            }
        }
        if (null == l1) {
            if (null == idx) {
                return l2;
            } else {
                idx.next = l2;
            }
        }
        if (null == l2) {
            if (null == idx) {
                return l1;
            } else {
                idx.next = l1;
            }
        }
        return head;
    }

    public static void main(String[] args) {

    }
}