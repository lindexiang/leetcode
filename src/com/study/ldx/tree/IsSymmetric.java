package com.study.ldx.tree;

/**
 * <p>101. 对称二叉树
 *
 * @author guanye
 * @date 2020/6/22 下午9:58
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        //采用的是前序遍历递归即可
        if (root == null)
            return true;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode roo1, TreeNode roo2) {
        if (roo1 == null && roo2 == null)
            return true;
        if (roo1 == null || roo2 == null)
            return false;

         return roo1.val == roo2.val && dfs(roo1.left, roo2.right) && dfs(roo1.right, roo2.left);
    }
}

/**
 给定一个二叉树，检查它是否是镜像对称的。

  

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

 1
 / \
 2   2
 / \ / \
 3  4 4  3
  

 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

 1
 / \
 2   2
 \   \
 3    3
*/
