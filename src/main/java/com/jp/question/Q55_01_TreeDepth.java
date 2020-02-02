package com.jp.question;

// 输入一棵二叉树，求该树的深度。
// 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
// 最长路径的长度为树的深度。

import com.jp.datastruct.TreeNode;

public class Q55_01_TreeDepth {

    public static int TreeDepth(TreeNode<Integer> root){
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null){
            return 1;
        }else{
            return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
        }
    }

    public static void main(String[] args){
        //            1
        //         /      \
        //        2        3
        //       /\         \
        //      4  5         6
        //        /
        //       7
        TreeNode<Integer> node7 = new TreeNode<>(7);
        TreeNode<Integer> node5 = new TreeNode<>(5,node7,null);
        TreeNode<Integer> node2 = new TreeNode<>(2,new TreeNode<>(4),node5);
        TreeNode<Integer> node3 = new TreeNode<>(3,null,new TreeNode<>(6));
        TreeNode<Integer> root = new TreeNode<>(1,node2,node3);
        System.out.println(TreeDepth(root));
    }
}
