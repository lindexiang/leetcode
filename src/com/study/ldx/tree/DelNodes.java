package com.study.ldx.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *
 * @author guanye
 * @date 2020/6/23 下午10:49
 */
public class DelNodes {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ret = new ArrayList<>();
        if (to_delete.length <= 0) {
            ret.add(root);
            return ret;
        }
        Set<Integer> set = new HashSet<>();
        for (int i: to_delete)
            set.add(i);
        dfs(null, root, ret, set);
        return ret;
    }

    //后续遍历
    public void dfs(TreeNode parent, TreeNode root, List<TreeNode> ret, Set<Integer> isDelete) {
        if (root == null)
            return;

        dfs(root, root.left, ret, isDelete);
        dfs(root, root.right, ret, isDelete);

        //如果当前的节点是需要被删除的
        if (isDelete.contains(root.val)) {
            if (root.left != null)
                ret.add(root.left);
            if (root.right != null)
                ret.add(root.right);
            if (parent != null && parent.left == root)
                parent.left = null;
            if (parent != null && parent.right == root)
                parent.right = null;
        } else if (parent == null) {
            ret.add(root);
        }


    }

}
