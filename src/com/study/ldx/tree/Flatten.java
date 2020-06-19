package com.study.ldx.tree;

/**
 * description: Flatten <br>
 * date: 2020/6/20 1:52 <br>
 * author: guanye <br>
 * version: 1.0 <br>
 *
 */
public class Flatten {
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        //先顺遍历 但是先遍历又子树 在遍历桌子书
        flatten(root.right);
        flatten(root.left);

        root.left = null;
        root.right = pre;
        pre = root;
    }
}

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
