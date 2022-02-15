package com.dogsong.a.review;

import com.dogsong.a.linkedlist.ListNode;

/**
 * [24] 两两交换链表中的节点
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/15
 */
public class Review_24 {

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            }
            if (l2 != null) {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }

        tail.next = null;

        return dummy.next;
    }

    public static ListNode swapPairs(ListNode head) {
        // 偶数链表
        ListNode evenDummy = new ListNode();
        ListNode evenTail = evenDummy;

        // 奇数链表
        ListNode oddDummy = new ListNode();
        ListNode oddTail = oddDummy;

        int index = 0;
        ListNode p = head;

        while (p != null) {
            ListNode back = p.next;

            if ((index & 0x01) == 0) {
                evenTail.next = p;
                evenTail = p;
            } else {
                oddTail.next = p;
                oddTail = p;
            }

            index ++;
            p = back;
        }

        evenTail.next = null;
        oddTail.next = null;

        return mergeTwoLists(oddDummy.next, evenDummy.next);
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c1;
        c1.next = c2;
        c2.next = d;
        d.next = e;

        System.out.println(swapPairs(a));


    }
}
