package com.study.ldx.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * @author guanye
 * @date 2020/6/22 下午10:43
 */
public class AllPossibleFBT {
    public List<TreeNode> allPossibleFBT(int N) {
        return dfs(N);
    }

    //dfs
    //构造左子树和又子树即可
    public List<TreeNode> dfs(int N) {
        List<TreeNode> ret = new ArrayList<>();
        if (N < 1)
            return ret;

        if (N == 1) {
            ret.add(new TreeNode(0));
            return ret;
        }

        for (int i = 1; i < N; i= i + 2) {
            List<TreeNode> left = dfs(i);
            List<TreeNode> right = dfs(N - 1 - i);
            for (TreeNode p1: left) {
                for (TreeNode p2: right) {
                    TreeNode root = new TreeNode(0);
                    root.left = p1;
                    root.right = p2;
                    ret.add(root);
                }
            }
        }
        return ret;
    }

}

/**
 * 894. 所有可能的满二叉树
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 *
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 *
 * 答案中每个树的每个结点都必须有 node.val=0。
 *
 * 你可以按任何顺序返回树的最终列表。
 *
 *
 *
 * 示例：
 *
 * 输入：7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 */
