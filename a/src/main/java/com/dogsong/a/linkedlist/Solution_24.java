package com.dogsong.a.linkedlist;

/**
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/12/13
 */
public class Solution_24 {

    public ListNode swapPairs(ListNode head) {
        ListNode odd = new ListNode();
        ListNode even = new ListNode();

        ListNode odd_tail = odd.next;
        ListNode even_tail = even.next;

        // split the list into 2 parts
        int idx = 1;
        ListNode p = head;
        while (p != null) {
            ListNode back = p.next;

            if ((idx & 0x01) == 1) {
                odd_tail.next = p;
                odd_tail = p;
            } else {
                even_tail.next = p;
                even_tail = p;
            }

            p = back;
            idx ++;
        }

        odd_tail.next = even_tail.next = null;
        return merge(odd.next, even.next);
    }

    public ListNode merge(ListNode odd, ListNode even) {
        boolean isEven = true;
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (odd != null || even != null) {
            if (odd == null || isEven && even != null) {
                tail.next = even;
                even = even.next;
            } else {
                tail.next = odd;
                odd = odd.next;
            }
            tail = tail.next;
            isEven = !isEven;
        }
        tail.next = null;
        return dummy.next;
    }

}
