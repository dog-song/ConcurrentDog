package com.dogsong.a.linkedlist;

/**
 * [82] 删除排序链表中的重复元素 II
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 *
 *
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/12/7
 */
public class Solution_82 {

    public static ListNode deleteDuplicates(ListNode head) {
        // 采用新生成 2条新链表的思路

        // ans 这个链表总是用来存放返回结果
        ListNode ans = new ListNode();
        ListNode ans_tail = ans;

        // tmp 这个链表中总是用来存放相同元素。
        // 如果发现要append一个不同的
        ListNode tmp = new ListNode();
        ListNode tmp_tail = tmp;
        ListNode p = head;

        while (p != null) {
            ListNode back = p.next;

            // 如果tmp链表为空，或者 tmp链表中的元素 和 p.val 相等 => 那么把p添加到tmp链表中
            if (tmp_tail == tmp || p.val == tmp_tail.val) {
                tmp_tail.next = p;
                tmp_tail = p;
            } else {
                // 如果发现和tmp链表中的元素不相等
                // 那么看一下tmp链表中的结点个数
                // 如果tmp链表中只有一个结点
                if (tmp_tail == tmp.next) {
                    // 那么这里把这个结点放到ans中
                    ans_tail.next = tmp.next;
                    ans_tail = tmp.next;
                }
                // 如果tmp链表中有多个结点，那么什么也不做

                // 无论tmp链表中是一个结点，还是有多个结点
                // 都要清空tmp链表

                tmp_tail = tmp;
                tmp.next = null;

                // 再把p结点安装到tmp上
                // 可以和前面的语句合并
                // 这里为了逻辑更清晰这么写。
                tmp_tail.next = p;
                tmp_tail = p;
            }
            p = back;
        }
        // 如果tmp链表中还有元素，并且只有一个
        if (tmp_tail == tmp.next) {
            ans_tail.next = tmp.next;
            ans_tail = tmp.next;
        }
        ans_tail.next = null;

        return ans.next;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(3);
        a.next = b;
        b.next = c1;
        c1.next = c2;

        ListNode res = deleteDuplicates(a);
        System.out.println(res);
    }

}
