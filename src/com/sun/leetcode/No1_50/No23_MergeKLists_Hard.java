package com.sun.leetcode.No1_50;

import com.sun.common.ListNode;

public class No23_MergeKLists_Hard {
    /**
     * 题目：将K个升序链表合并为一个新的 升序 链表并返回。
     * 思路：循环K个链表，并修改节点next指向，不新建节点，节省内存，时间复杂度O(M*K)，m为所有节点个数，k为链表个数
     * 优化方法：采用归并排序的思想，将K个链表的合并转化为两个链表的排序，此时时间复杂度为O(M*logK)
     *
     * @param lists K个升序链表
     * @return 合并后的链表头结点
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode idx = head;
        while (true) {
            // 目前有n个List还未遍历到末尾
            int n = 0;
            // 用于记录当前循环中第k个List中的节点为最小值
            int k = 0;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    n++;
                    if (lists[i].val < minValue) {
                        minValue = lists[i].val;
                        k = i;
                    }
                }
            }
            // 如果所有列表的所有节点都遍历完，则结束
            if (0 == n) {
                break;
            }
            // 给idx插入下一个节点
            idx.next = lists[k];
            idx = idx.next;
            // 最小值所在List的指针向后移
            lists[k] = lists[k].next;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }
}
