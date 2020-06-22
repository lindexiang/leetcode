package com.study.ldx.tree;

import java.util.*;

/**
 * 652. 寻找重复的子树
 * description: FindDuplicateSubtrees <br>
 * date: 2020/6/23 1:10 <br>
 * author: guanye <br>
 * version: 1.0 <br>
 */
public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ret = new ArrayList<>();
        dfs(root,ret, new HashMap<>());
        return ret;
    }

    //通过编码序列化实现
    //后续遍历 从最底下开始编码
    public String dfs(TreeNode root, List<TreeNode> ret, Map<String, Integer> count) {
        if (root == null)
            return "#";

        String left = dfs(root.left, ret, count);
        String right = dfs(root.right, ret, count);
        String cur = root.val + "," + left + ","+ right;
        if (count.containsKey(cur) && count.get(cur) == 1)
            ret.add(root);

        count.put(cur, count.getOrDefault(cur, 0) + 1);
        return cur;
    }

}

/**
 * 652. 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 */
