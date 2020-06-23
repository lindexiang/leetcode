package com.study.ldx.tree;

/**
 * description: MaxAncestorDiff <br>
 * date: 2020/6/24 1:00 <br>
 * author: guanye <br>
 * version: 1.0 <br>
 */
public class MaxAncestorDiff {

    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;
        maxValue = 0;
        dfs(root);
        return maxValue;
    }

    public static int maxValue = 0;

    //第一个是最大值 第二个是最小值
    //使用后续遍历
    //使用先序遍历也可以 public void dfs(root, max, min)
    public int[] dfs(TreeNode root) {
        if (root == null)
            return null;


        int[] left = dfs(root.left);
        int [] right = dfs(root.right);

        if (left == null && right == null) {
            return new int[] {root.val, root.val};
        }


        int max, min;
        if (left == null || right == null) {
            max =  left == null ? right[0] : left[0];
            min = left == null ? right[1] : left[1];
        } else {
            max = Math.max(left[0], right[0]);
            min = Math.min(left[1], right[1]);
        }

        maxValue = Math.max(maxValue, Math.abs(max - root.val));
        maxValue = Math.max(maxValue, Math.abs(min - root.val));
        if (root.val > max)
            max = root.val;
        if (root.val < min) {
            min = root.val;
        }
        return new int[]{max, min};
    }
}

/**
 * 1026. 节点与其祖先之间的最大差值
 * 给定二叉树的根节点 root，找出存在于不同节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 *
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：[8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 *
 *
 * 提示：
 *
 * 树中的节点数在 2 到 5000 之间。
 * 每个节点的值介于 0 到 100000 之间。
 */

