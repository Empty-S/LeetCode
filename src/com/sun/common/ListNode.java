package com.sun.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
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