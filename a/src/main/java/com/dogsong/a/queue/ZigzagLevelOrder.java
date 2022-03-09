package com.dogsong.a.queue;

import com.dogsong.a.tree.TreeNode;

import java.util.*;

/**
 * [103] 二叉树的锯齿形层序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/9
 */
public class ZigzagLevelOrder {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // FIFO 队列
        Queue<TreeNode> Q = new LinkedList<>();

        if (root != null) {
            Q.offer(root);
        }

        List<List<Integer>> ans = new ArrayList<>();
        boolean reverse = false;

        // 利用FIFO队列进行层次遍历
        while (Q.size() > 0) {
            // 当前层的个数
            final int qSize = Q.size();

            // 当前层的结果
            List<Integer> tmp = new ArrayList<>(qSize);

            for (int i = 0; i < qSize; i++) {
                // 当前层 前面的节点先出队列
                TreeNode cur = Q.poll();
                tmp.add(cur.val);

                if (cur.left != null) {
                    Q.offer(cur.left);
                }

                if (cur.right != null) {
                    Q.offer(cur.right);
                }
            }
            if (reverse) {
                Collections.reverse(tmp);
            }

            ans.add(tmp);
            reverse = !reverse;
        }
        return ans;
    }

}
