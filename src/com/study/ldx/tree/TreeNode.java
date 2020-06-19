package com.study.ldx.tree;

/**
 * description: TreeNode <br>
 * date: 2020/6/20 1:52 <br>
 * author: guanye <br>
 * version: 1.0 <br>
 */
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}
