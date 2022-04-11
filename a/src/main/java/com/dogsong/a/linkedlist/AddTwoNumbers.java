package com.dogsong.a.linkedlist;

/**
 * 两数相加
 *
 * [2] https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/4/11
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        ListNode p = l1;
        ListNode q = l2;

        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return dummy.next;
    }

}
