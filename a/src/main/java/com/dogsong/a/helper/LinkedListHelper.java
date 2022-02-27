package com.dogsong.a.helper;

import com.dogsong.a.linkedlist.ListNode;

/**
 * 链表测试
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/2/27
 */
public class LinkedListHelper {

    /**
     * 构造一个链表
     * 1 -> 2 -> 3 -> 4 -> 5 -> null
     */
    public static ListNode createLinedList() {
        ListNode head = new ListNode(1);
        ListNode tail = head.setNext(2);
        tail = tail.setNext(3);
        tail = tail.setNext(4);
        tail.setNext(5);
        return head;
    }

    /**
     * 构建上面链表的反转链表
     * 1 -> 2 -> 3 -> 4 -> 5 -> null
     */
    public static ListNode createReversedLinedList() {
        ListNode head = new ListNode(5);
        ListNode tail = head.setNext(4);
        tail = tail.setNext(3);
        tail = tail.setNext(2);
        tail.setNext(1);
        return head;
    }

    /**
     * 比较两个链表是否相等
     */
    public static boolean isSameLinkedList(ListNode a, ListNode b) {
        if (a == null && b == null) return false;
        if (a == null || b == null) return false;
        return a.val == b.val && isSameLinkedList(a.next, b.next);
    }

    /**
     * 打印链表
     */
    public static void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.println(head.val + "->");
            head = head.next;
        }
        System.out.println("null\n");
    }

    public static void main(String[] args) {
        LinkedListHelper.printLinkedList(LinkedListHelper.createLinedList());

        LinkedListHelper.printLinkedList(LinkedListHelper.createReversedLinedList());
    }

}
