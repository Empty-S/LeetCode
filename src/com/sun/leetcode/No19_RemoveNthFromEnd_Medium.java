package com.sun.leetcode;

public class No19_RemoveNthFromEnd_Medium {

    /**
     * 题目：删除链表的倒数第N个结点
     *      进阶：一次循环搞定
     * 思路：找到倒数第N+1个节点
     *      idx用于循环链表，beforeNthFromEnd始终与idx保持N+1的距离
     *      此时当idx为null时，beforeNthFromEnd为倒数第N+1个节点
     *
     * @param head 头结点
     * @param n    倒数第N个节点
     * @return 头结点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
            return null;
        }
        ListNode idx = head;
        ListNode beforeNthFromEnd = null;
        for (int i = 0; null != idx; i++) {
            idx = idx.next;
            if (i >= n) {
                if (null == beforeNthFromEnd) {
                    beforeNthFromEnd = head;
                    continue;
                }
                beforeNthFromEnd = beforeNthFromEnd.next;
            }
        }
        // 对于去除第一个节点的特殊处理
        if (null == beforeNthFromEnd) {
            return head.next;
        }
        beforeNthFromEnd.next = beforeNthFromEnd.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode idx = head;
        for (int i = 2; i <= 8; i++) {
            idx.next = new ListNode(i);
            idx = idx.next;
        }
        System.out.println(head);
//        System.out.println(removeNthFromEnd(head, 1));
//        System.out.println(removeNthFromEnd(head, 3));
        System.out.println(removeNthFromEnd(head, 8));

    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ListNode idx = this;
        while (null != idx) {
            sb.append(idx.val).append(", ");
            idx = idx.next;
        }
        sb.replace(sb.length() - 2, sb.length(), "]");
        return sb.toString();
    }
}
