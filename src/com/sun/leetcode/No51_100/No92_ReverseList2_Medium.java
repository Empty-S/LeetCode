package com.sun.leetcode.No51_100;

import com.sun.common.ListNode;
import com.sun.util.InputStringConvert;

public class No92_ReverseList2_Medium {
    /**
     * 题目：给定单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
     * 思路：首先找到 left 的前一个节点 previous 和 right 的后一个节点 next，用 start 永远指向 left 节点，
     *      随后将 start 的下一个节点不断插入到 previous 的后面，直到 start 的下一个节点为 next，此时已经完成了区间内的反转。
     *      需注意 left = 1 时，previous 为 head，会导致上述插入的实际位置是 left 的下一个节点，导致循环后的结果是 [left+1, right]范围内的逆序，因此最后需将 left 节点单独处理。
     *
     * @param head  头节点
     * @param left  反转起始左边界
     * @param right 反转终止右边界
     * @return 反转后的链表
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right || head.next == null) {
            return head;
        }
        // left 的前一个节点，若 left = 1，则默认为 head 节点
        ListNode previous = head;
        // right 的后一个节点
        ListNode next = head;
        // 用于遍历
        ListNode idx = head;
        for (int i = 1; i <= right; i++, idx = idx.next) {
            if (i == left - 1) {
                previous = idx;
            }
            if (i == right) {
                next = idx.next;
                break;
            }
        }
        // 永远指向 left 节点位置
        ListNode start = previous.next;
        idx = start.next;
        while (idx != next) {
            // 将节点插入 previous 后面
            start.next = idx.next;
            idx.next = previous.next;
            previous.next = idx;
            idx = start.next;
        }
        // 对于 left = 1 的单独处理，此时 previous = head, start.next = next = idx
        if (left == 1) {
            head = previous.next;
            previous.next = start.next;
            start.next = previous;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(InputStringConvert.stringToIntArray("[1,2,3,4,5]"));
        System.out.println(reverseBetween(head1, 1, 5));

        ListNode head2 = new ListNode(InputStringConvert.stringToIntArray("[5]"));
        System.out.println(reverseBetween(head2, 1, 1));
    }
}
