package com.dogsong.a.linkedlist;

/**
 * [25] K 个一组翻转链表
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/16
 */
public class ReverseKGroup {

    private static ListNode tmp = new ListNode();
    private static ListNode tmpTail = tmp;
    private static int len = 0;

    private static ListNode ans = new ListNode();
    private static ListNode ansTail = ans;

    /**
     * 反转链表
     */
    private static ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode();

        while (head != null) {
            ListNode tmp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = tmp;
        }
        return dummy.next;
    }

    private static void append(ListNode p, int k) {
        tmpTail.next = p;
        tmpTail = p;
        len ++;

        if (len == k) {
            ListNode tail = tmp.next;
            ListNode head = reverse(tmp.next);

            ansTail.next = head;
            ansTail = tail;

            len = 0;
            tmp.next = null;
            tmpTail = tmp;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        while (head != null) {
            ListNode back = head.next;
            head.next = null;
            append(head, k);
            head = back;
        }

        if (len > 0) {
            ansTail.next = tmp.next;
            ansTail = tmpTail;
        }

        ansTail.next = null;
        return ans.next;
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

        System.out.println(reverseKGroup(a, 3));


    }

}
