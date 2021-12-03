package com.dogsong.a;

/**
 * [203] 移除链表元素
 *
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/12/3
 */
public class Solution_203 {

    /**
     * 时间复杂度 O(N)，空间复杂度 O(1)
     */
    public ListNode removeElements(ListNode head, int val) {
        // 生成一个新链表
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        // 依次取出旧链表中的每个结点
        ListNode p = head;
        while (p != null) {
            ListNode back = p.next;
            // 如果结点值需要保留，那么采用属部追加的方法
            // 添加到新链表中
            if (p.val != val) {
                tail.next = p;
                tail = p;
            }
            p = back;
        }
        // 注意设置尾巴的next为空
        tail.next = null;
        // 注意返回的是dummy.next
        return dummy.next;
    }
}
