package com.dogsong.a.review;

import com.dogsong.a.linkedlist.ListNode;

/**
 * 反转链表
 *
 * @see com.dogsong.a.linkedlist.Solution_206
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2022/1/13
 */
public class Test_206 {

    public static ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        while (null != head) {
            ListNode tmp = head.next;
            // 头插
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
