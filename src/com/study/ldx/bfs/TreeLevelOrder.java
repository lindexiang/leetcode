package com.study.ldx.bfs;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * description: TreeLevelOrder <br>
 * date: 2020/6/7 22:55 <br>
 * author: guanye <br>
 * version: 1.0 <br>
 */



public class TreeLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null)
            return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int step = 0;
        while (!queue.isEmpty()) {
            List<Integer> solution = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i< size; i++) {
                TreeNode cur = queue.poll();
                solution.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);

            }
            if (step % 2 == 1) {
                Collections.reverse(solution);
            }
            ret.add(solution);
            step++;
        }
        return ret;
    }




}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
