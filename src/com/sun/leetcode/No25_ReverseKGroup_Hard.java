package com.sun.leetcode;

import com.sun.common.ListNode;

public class No25_ReverseKGroup_Hard {

    /**
     * 题目：给定一个链表，每k个节点一组进行翻转，并返回交换后的链表。
     * 思路：以K个为一组，首先遍历出组内第一个和最后一个节点；其次组内遍历，逆序相邻节点
     *
     * @param head 链表
     * @param k K个节点一组
     * @return 合并后的链表头结点
     */
    public ListNode reverseKGroup1(ListNode head, int k) {
        if (null == head || k < 0) {
            return null;
        }
        // 初始化变量
        ListNode previous = null; // K个节点的前一个节点
        ListNode first = head; // K个节点的第一个
        ListNode last = head; // K个节点的最后一个
        int i = 1;
        // 外层大循环，按k分组，找到组内第一个和最后一个节点
        while (last != null) {
            if (i < k) {
                i++;
                last = last.next;
                continue;
            }
            if (i == k) {
                // 下一组的第一个节点
                ListNode nextFirst = last.next;
                ListNode n1 = first;
                ListNode n2 = n1.next;
                // 防止链表成环，先将组内第一个节点（反转后的最后一个节点）连到下一组的第一个节点
                first.next = nextFirst;
                // 组内循环，逆序链表
                for (int j = 1; j < k; j++) {
                    ListNode n3 = n2.next;
                    n2.next = n1;
                    n1 = n2;
                    n2 = n3;
                }
                // 链接上一组的最后一个节点
                if (null == previous) {
                    head = last;
                } else {
                    previous.next = last;
                }
                // 初始化下一组
                previous = first;
                first = nextFirst;
                last = nextFirst;
                i = 1;
            }
        }
        System.gc();
        return head;
    }

    /**
     * 进阶：只用O(n)空间复杂度解决该问题
     * 思路：
     * @param head 链表
     * @param k K个节点一组
     * @return 合并后的链表头结点
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i <= 2; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        System.out.println(head);
        No25_ReverseKGroup_Hard reverseKGroup = new No25_ReverseKGroup_Hard();
        System.out.println(reverseKGroup.reverseKGroup1(head, 2));

    }
}
