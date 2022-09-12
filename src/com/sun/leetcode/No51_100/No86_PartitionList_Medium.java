package com.sun.leetcode.No51_100;

import com.sun.common.ListNode;
import com.sun.util.InputStringConvert;

public class No86_PartitionList_Medium {
    /**
     * 题目：给定一个链表的头节点 head 和一个特定值 x ，对链表进行分隔，使得所有 < x 的节点都出现在 >= x 的节点之前。
     *      应当 保留 两个分区中每个节点的初始相对位置。
     * 思路：快排中 partition() 的思路相同，链表左侧为 < x 的节点，右侧为 >= x 的节点，
     *  设置两个指针，一个指针 idx 迭代数组，一个指针 leftEndIdx 指向左侧分区的最后一个节点，当 idx.next 为 < x的节点时，将其放在 leftEndIdx 之后。
     *
     * @param head 头节点
     * @param x    分割数字
     * @return 修改后的链表头节点
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode idx = head;
        ListNode leftEndIdx = null;
        // 由于使用的是 idx.next，因此对 head 节点单独判断
        if (head.val < x) {
            leftEndIdx = head;
        }
        while (idx.next != null) {
            ListNode next = idx.next;
            if (next.val < x) {
                // 将 next 的上游节点与下游节点相连
                idx.next = next.next;
                // 若当前左分区没有节点，则需将该节点挪到最左侧，且设置为 head 节点
                if (leftEndIdx == null) {
                    next.next = head;
                    head = next;
                } else { // 若左分区已有节点，则放置在其后
                    next.next = leftEndIdx.next;
                    leftEndIdx.next = next;
                }
                // 若始终没遇到右分区节点时，idx 与 leftEndIdx 共同向右移动，避免出现 idx < leftEndIdx的情况
                if (idx == leftEndIdx) {
                    idx = next;
                }
                leftEndIdx = next;
            } else {
                // 出现右分区节点时才迭代，避免 idx 的新下游（仍为左分区节点）被错过
                idx = idx.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(InputStringConvert.stringToIntArray("[1,4,3,2,5,2]"));
        System.out.println(partition(head1, 3));

        ListNode head2 = new ListNode(InputStringConvert.stringToIntArray("[2,1]"));
        System.out.println(partition(head2, 2));

        ListNode head3 = new ListNode(InputStringConvert.stringToIntArray("[1,1]"));
        System.out.println(partition(head3, 2));
    }
}
