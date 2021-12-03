package com.dogsong.a;

/**
 * [206] 链表反转
 *
 * 测试平台链接：
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/12/3
 */
public class Solution_206 {

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
            this.val = x;
        }

    }

    public ListNode reverseList(ListNode head) {
        // 建立一个新的带假头的新链表
        ListNode dummy = new ListNode();
        // 开始遍历旧链表
        while (head != null) {
            ListNode tmp = head.next;
            // 把旧链表中的结点取出来，采用头部插入的方法添加到新链表中
            head.next = dummy.next;
            dummy.next = head;
            head = tmp;
        }
        // 返回新链表的头，注意，不要返回dummy!!
        return dummy.next;
    }
}
