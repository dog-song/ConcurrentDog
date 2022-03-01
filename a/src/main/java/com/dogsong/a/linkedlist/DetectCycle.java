package com.dogsong.a.linkedlist;

/**
 * [142] 环形链表ii
 *
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/1
 */
public class DetectCycle {

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode s1 = head;
        ListNode s2 = head;

        while (s2 != null && s2.next != null) {
            s1 = s1.next;
            s2 = s2.next.next;
            if (s1 == s2) {
                break;
            }
        }
        if (s1 != s2) {
            return null;
        }
        s1 = head;
        while (s1 != s2) {
            s1 = s1.next;
            s2 = s2.next;
        }
        return s1;
    }

}
