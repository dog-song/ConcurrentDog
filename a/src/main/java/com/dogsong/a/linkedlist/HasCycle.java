package com.dogsong.a.linkedlist;

/**
 * [141] 环形链表
 *
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/28
 */
public class HasCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode s1 = head;
        ListNode s2 = head;

        while (s2 != null && s2.next != null) {
            s2 = s2.next.next;
            s1 = s1.next;
            if (s1 == s2) {
                break;
            }
        }

        return s1 == s2;
    }

}
