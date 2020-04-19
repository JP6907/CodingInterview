package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
//Note: A leaf is a node with no children.
public class Q111_MinimumDepthofBinaryTree {

    static int min = Integer.MAX_VALUE;
    public static int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root,1);
        return min;
    }

    public static void dfs(TreeNode node,int level){
        if(node==null)
            return;
        if(node.left==null&&node.right==null)
            min = Math.min(min,level);
        else{
            dfs(node.left,level+1);
            dfs(node.right,level+1);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1,new TreeNode(2),null);
        int result = minDepth(node);
        System.out.println(result);
    }
}
