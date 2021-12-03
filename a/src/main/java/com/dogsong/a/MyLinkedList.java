package com.dogsong.a;

/**
 * [707] 设计链表
 *
 * 测试平台链接：
 * - https://leetcode-cn.com/problems/design-linked-list/
 *
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/12/2
 */
public class MyLinkedList {

    /**
     * 链表的定义
     */
    class ListNode {
        /** val用来存放链表中的数据 */
        public int val = 0;

        /** next指向下一个结点 */
        public ListNode next = null;

        public ListNode() {}

        public ListNode(int x) {
            val = x;
        }
    }

    private ListNode dummy = new ListNode();
    private ListNode tail = dummy;
    private int length = 0;

    /**
     * 初始化链表
     */
    public MyLinkedList() {

    }

    /**
     * 将值为 val 的结点追加到链表尾部
     */
    public void addAtTail(int val) {
        // 尾部添加一个新结点
        tail.next = new ListNode(val);
        // 移动tail指针
        tail = tail.next;
        // 链表长度+1
        length++;
    }

    /**
     * 插入值val的新结点，使它成为链表的第一个结点
     */
    public void addAtHead(int val) {
        // 生成一个新节点，存放值 val
        ListNode p = new ListNode(val);
        // 将 p.next 指向第一个节点
        p.next = dummy.next;
        // dummy.next 指向新节点，使之变成第一个节点
        dummy.next = p;
        // 如果原来的 tail 指向 dummy，那么将 tail 指向新节点
        if (tail == dummy) {
            tail = p;
        }
        length ++;
    }

    /**
     * 获取链表中第 index 个结点的值。如果索引无效，则返回 -1
     * index从0开始。
     */
    public int get(int index) {
        // index 从 0 开始
        if (index < 0 || index >= length) {
            return -1;
        }

        // 因为 getPrevNode 总是有效的节点，所以可以直接取值
        return getPrevNode(index).next.val;
    }

    /**
     * 返回 index 结点的前驱结点，如果 index 不存在，那么返回 dummy
     */
    public ListNode getPrevNode(int index) {
        // 初始化front与back，分别一前一后
        ListNode front = dummy.next;
        ListNode back = dummy;

        // 在查找的时候，front与back总是一起走
        for (int i = 0; i < index && front != null; i++) {
            back = front;
            front = front.next;
        }

        // 把back做为prev并且返回
        return back;
    }

    /**
     * 在链表中的第 index 个结点之前添加值为 val  的结点
     * 1. 如果 index 等于链表的长度，则该结点将附加到链表的末尾。
     * 2. 如果 index 大于链表长度，则不会插入结点.
     * 3. 如果index小于0，则在头
     */
    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        } else if (index == length) {
            addAtTail(val);
        } else if (index <= 0) {
            addAtHead(val);
        } else {
            ListNode pre = getPrevNode(index);
            ListNode p = new ListNode(val);
            p.next = pre.next;
            pre.next = p;
            length ++;
        }
    }

    /**
     * 如果索引index有效，则删除链表中的第index个结点.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }

        ListNode pre = getPrevNode(index);

        if (tail == pre.next) {
            tail = pre;
        }

        pre.next = pre.next.next;
        length --;
    }

}
