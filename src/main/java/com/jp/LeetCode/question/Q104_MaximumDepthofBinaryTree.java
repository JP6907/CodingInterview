package com.jp.LeetCode.question;


import com.jp.LeetCode.datastruct.TreeNode;

public class Q104_MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
