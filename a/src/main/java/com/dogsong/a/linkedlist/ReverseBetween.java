package com.dogsong.a.linkedlist;


/**
 * 反转链表ii
 *
 * [92] https://leetcode-cn.com/problems/reverse-linked-list-ii/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/4/10
 */
public class ReverseBetween {

    private void reverse(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode temp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = temp;
        }
        head = dummy.next;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        // 初始化
        ListNode pre = dummy;
        // 寻址
        for (int i = 0; i < left - 1; i ++) {
            pre = pre.next;
        }
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i ++) {
            rightNode = rightNode.next;
        }
        ListNode curr = rightNode.next;
        ListNode leftNode = pre.next;
        // 切分
        pre.next = null;
        rightNode.next = null;
        // 反转
        reverse(leftNode);
        // 连接
        pre.next = rightNode;
        leftNode.next = curr;

        return dummy.next;
    }
}
