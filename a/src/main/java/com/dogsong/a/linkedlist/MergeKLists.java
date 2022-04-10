package com.dogsong.a.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * [23] 合并K个升序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * @see <a href="https://kaiwu.lagou.com/course/courseInfo.htm?courseId=685#/detail/pc?id=6694">练习题 3：给定 k 个有序链表，合并成一个有序链表</a>
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 *
 * @author <a href="mailto:dogsong99@gmail.com">domi</a>
 * @since 2021/12/10
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        final int N = lists == null ? 0 : lists.length;

        // Queue<ListNode> Q = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        Queue<ListNode> Q = new PriorityQueue<>(Comparator.comparingInt(v -> v.val));

        for (int i = 0; i < N; i++) {
            ListNode t = lists[i];
            if (t != null) {
                Q.add(t);
            }
        }

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (!Q.isEmpty()) {
            ListNode cur = Q.poll();

            tail.next = cur;
            tail = cur;

            if (cur.next != null) {
                Q.add(cur.next);
            }
        }

        tail.next = null;
        return dummy.next;
    }

}
