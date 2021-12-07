package com.dogsong.a;

/**
 * [83] 删除排序链表中的重复元素
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 *
 *
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/12/7
 */
public class Solution_83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode p = head;

        while (p != null) {
            ListNode back = p.next;

            if (tail == dummy || tail.val != p.val) {
                tail.next = p;
                tail = p;
            }
            p = back;
        }
        tail.next = null;
        return dummy.next;
    }

}
