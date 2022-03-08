package com.dogsong.a.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * [160] 相交链表
 *
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/8
 */
public class IntersectionNode {

    /**
     * 时间复杂度：O(m+n), 其中 mm 和 nn 是分别是链表 headA 和 headB 的长度。需要遍历两个链表各一次。
     * 空间复杂度：O(m), 其中 mm 是链表 headA 的长度。需要使用哈希集合存储链表 headA 中的全部节点。
     *
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode tmp = headA;
        while (tmp != null) {
            visited.add(tmp);
            tmp = tmp.next;
        }

        tmp = headB;
        while (tmp != null) {
            if (visited.contains(tmp)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }
}
