package com.study.ldx.tree;

/**
 * 1315. 祖父节点值为偶数的节点和
 * description: SumEvenGrandparent <br>
 * date: 2020/6/23 1:43 <br>
 * author: guanye <br>
 * version: 1.0 <br>
 */
public class SumEvenGrandparent {

    //后续遍历
    //左子树的和+右子树的和+当前的root的和
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;

        int sum = sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
        if (root.val % 2 != 0)
            return sum;

        if (root.left != null) {
            if (root.left.left != null)
                sum += root.left.left.val;
            if (root.left.right != null)
                sum += root.left.right.val;
        }
        if (root.right != null) {
            if (root.right.left != null)
                sum += root.right.left.val;
            if (root.right.right != null)
                sum += root.right.right.val;
        }

        return sum;
    }


}

/**
 * 1315. 祖父节点值为偶数的节点和
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 *
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 *
 *
 * 提示：
 *
 * 树中节点的数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 */