package com.study.ldx.tree;

import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 *
 * @author guanye
 * @date 2020/6/22 下午8:54
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)return "[]";
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("null,");
            } else {
                sb.append(cur.val + ",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //反序列化
        if (data.equals("[]"))
            return null;

        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if(!vals[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(cur.left);
            }
            i++;
            if(!vals[i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(cur.right);
            }
            i++;
        }
        return root;
    }

}
