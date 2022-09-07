package com.sun.leetcode.No51_100;

import com.sun.common.ListNode;
import com.sun.util.InputStringConvert;

public class No82_DelDuplicatesInList2_Medium {
    /**
     * 题目：给定一个已排序的链表的头 head，删除原始链表中所有重复数字的节点，只留下不同的数字。返回 已排序的链表。
     * 思路：与 No.83 相比，核心是找到首个不重复的数字作为 head 节点，当 head 数字无重时，则当前 head 可用作返回 head；
     *      当 head 含重复数字时，找到第一个无重数字作为 head。
     *
     * @param head 含重复数字的链表头节点
     * @return 已剔除重复数字的链表头节点
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode end = null;
        for (ListNode idx = head; idx.next != null; idx = idx.next) {
            if (idx.val != idx.next.val) {
                // head 数字无重，idx = head 时，此时 end 必定没有进行过初始化，因此可以省略判断条件中的 end == null
                if (idx == head) {
                    end = head;
                }
                // head 数字有重时，不会进第一个 if，通过 end 是否赋值来判断是否已经找到新的 head
                if (idx.next.next == null || idx.next.val != idx.next.next.val) {
                    if (end == null) {
                        head = idx.next;
                        end = head;
                    } else {
                        end.next = idx.next;
                        end = end.next;
                    }
                }
            }
        }
        if (end != null) {
            end.next = null;
        } else {
            head = null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(InputStringConvert.stringToIntArray("[1,2,3,3,4,4,5]"));
        System.out.println(deleteDuplicates(head1));

        ListNode head2 = new ListNode(InputStringConvert.stringToIntArray("[1,1,1,2,2,3,4,4,5,6,7,7,8,8,8]"));
        System.out.println(deleteDuplicates(head2));

        ListNode head3 = new ListNode(InputStringConvert.stringToIntArray("[1,1]"));
        System.out.println(deleteDuplicates(head3));
    }
}
