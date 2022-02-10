package com.dogsong.a.review02;

import com.dogsong.a.linkedlist.ListNode;

/**
 * 反转链表
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2022/1/13
 */
public class review206 {

    public static ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode tmp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = tmp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(reverseList(a));

    }
}
