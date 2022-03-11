package com.dogsong.a.tree.dfs;

import com.dogsong.a.tree.TreeNode;

/**
 * [236] 二叉树的最近公共祖先
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/11
 */
public class LowestCommonAncestor {

    // 前序遍历

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) return root;

        TreeNode l = lowestCommonAncestor(root.left, p, q);

        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (l != null && r != null) {
            return root;
        }

        return l != null ? l : r;
    }

}
