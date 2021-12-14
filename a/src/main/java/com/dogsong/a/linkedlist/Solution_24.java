package com.dogsong.a.linkedlist;

/**
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/12/13
 */
public class Solution_24 {

    public ListNode swapPairs(ListNode head) {
        // 生成奇数 index 应该存放的链表
        ListNode oddDummy = new ListNode();
        ListNode oddTail = oddDummy;

        // 生成偶数 index 应该存放的链表
        ListNode evenDummy = new ListNode();
        ListNode evenTail = evenDummy;

        // split the list into 2 parts
        int idx = 0;
        ListNode p = head;
        while (p != null) {
            ListNode back = p.next;

            // 判断是否是奇数, 是偶数, 放在偶数的链表中
            if ((idx & 0x01) == 0) {
                evenTail.next = p;
                evenTail = p;
            } else {
                oddTail.next = p;
                oddTail = p;
            }

            p = back;
            idx ++;
        }

        oddTail.next = evenTail.next = null;
        return mergeList(oddDummy.next, evenDummy.next);
    }

    public ListNode mergeList(ListNode odd, ListNode even) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        boolean isEven = true;

        // 合并两个链表
        while (odd != null || even != null) {
            // odd 不为 null, 先取 odd 节点
            if (isEven && odd != null) {
                tail.next = odd;
                tail = odd;
                odd = odd.next;
            } else { // 否则, 取 even 节点
                tail.next = even;
                tail = even;
                even = even.next;
            }
            isEven = !isEven;
        }
        // 尾部设为 null
        tail.next = null;
        return dummy.next;
    }

}
