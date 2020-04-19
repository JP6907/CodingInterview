package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

public class Q226_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
