package com.dogsong.a.tree.bfs;

import com.dogsong.a.tree.TreeNode;

import java.util.*;

/**
 * [103] 二叉树的锯齿形层序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/23
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.offer(root);
        }
        List<List<Integer>> ans = new ArrayList<>();

        // 控制反转
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (reverse) {
                Collections.reverse(level);
            }
            ans.add(level);
            reverse = !reverse;
        }
        return ans;
    }
}
