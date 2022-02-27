package com.dogsong.a.linkedlist;

/**
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/12/8
 */
public class MergeTwoLists {

    /**
     * 时间复杂度 O(N)，空间复杂度 O(1)
     *
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 首先定义一个空链表
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        // 遍历两个有序链表，每次只取一个节点 append 到新链表尾部
        while (l1 != null || l2 != null) {
            // 如果 l2 为空，或者 l1 的值更小，那么取 l1 节点追加到链表尾部
            if (l2 == null || l1 != null && l1.val < l2.val) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            } else {
                // 其他情况就把 l2 增加到链表尾部
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        tail.next = null;

        return dummy.next;
    }
}
