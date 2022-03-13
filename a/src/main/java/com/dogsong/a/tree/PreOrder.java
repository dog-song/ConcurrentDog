package com.dogsong.a.tree;

import java.util.List;

/**
 * 树的前序遍历
 *
 * @author <a href="mailto:dogsong99@gmail.com">dogsong</a>
 * @since 2022/3/14
 */
public class PreOrder {

    public static void preOrder(TreeNode root, List<Integer> ans) {
        if (root != null) {
            ans.add(root.val);

            preOrder(root.left, ans);
            preOrder(root.right, ans);
        }
    }

}
