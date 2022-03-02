package com.dogsong.a.tree.bfs;

import com.dogsong.a.tree.TreeNode;
import com.google.common.collect.Lists;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * [102] 二叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/2
 */
public class LevelOrder {


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = Lists.newArrayList();

        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> level = Lists.newArrayList();

            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.add(node.left);

                if (node.right != null) queue.add(node.right);
            }
            ans.add(level);
        }

        return ans;
    }
}
