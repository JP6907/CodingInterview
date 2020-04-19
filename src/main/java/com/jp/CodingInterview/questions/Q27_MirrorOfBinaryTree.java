package com.jp.CodingInterview.questions;

import com.jp.CodingInterview.datastruct.TreeNode;


// 27：二叉树的镜像
// 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//二叉树的镜像定义：源二叉树
//    	    8
//    	   /  \
//    	  6   10
//    	 / \  / \
//    	5  7 9 11
//    	镜像二叉树
//    	    8
//    	   /  \
//    	  10   6
//    	 / \  / \
//    	11 9 7  5
public class Q27_MirrorOfBinaryTree {

    public static void Mirror(TreeNode<Integer> root){
        if(root!=null){
            TreeNode<Integer> left = root.lchild;
            root.lchild = root.rchild;
            root.rchild = left;
            Mirror(root.lchild);
            Mirror(root.rchild);
        }
    }

    public static void main(String[] args){
        TreeNode<Integer> node10119 = new TreeNode<>(10,11,9);
        TreeNode<Integer> node675 = new TreeNode<>(6,7,5);
        TreeNode<Integer> root = new TreeNode<>(8,node10119,node675);
        Mirror(root);
        TreeNode.PrintTree(root);
    }
}
