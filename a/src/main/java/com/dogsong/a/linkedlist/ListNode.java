package com.dogsong.a.linkedlist;

/**
 * 链表的定义
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/12/3
 */
public class ListNode {

    /** val用来存放链表中的数据 */
    public int val = 0;

    /** next指向下一个结点 */
    public ListNode next = null;

    public ListNode() {}

    public ListNode(int x) {
        this.val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
