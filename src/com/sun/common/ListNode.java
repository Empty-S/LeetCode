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

    public ListNode(int[] nums) {
        ListNode last = null;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                this.val = nums[i];
                last = this;
                continue;
            }
            ListNode cur = new ListNode(nums[i]);
            last.next = cur;
            last = cur;
        }
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