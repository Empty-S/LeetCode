package com.sun.leetcode.No51_100;

import com.sun.common.ListNode;

public class No61_RotateList_Medium {

    /**
     * 题目：给定一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     *      例：1,2,3,4,5旋转2后，变为 4,5,1,2,3
     * 思路：首先将链表处理为循环链表，其次根据链表长度，将 k 取模
     *      由于向右旋转，其实是逆向遍历，因此移动 len - k % len 次
     *
     * @param head 头节点
     * @param k    旋转 k 次
     * @return 旋转后的头节点
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode idx = head;
        while (true) {
            len++;
            // 循环到最后一个节点时，将链表处理为循环链表
            if (idx.next == null) {
                idx.next = head;
                break;
            }
            idx = idx.next;
        }
        int moveLen = len - k % len;
        ListNode last = head;
        for (int i = 0; i < moveLen; i++) {
            last = head;
            head = head.next;
        }
        last.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] headList = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(headList);
        System.out.println(rotateRight(head, 44));
    }
}
