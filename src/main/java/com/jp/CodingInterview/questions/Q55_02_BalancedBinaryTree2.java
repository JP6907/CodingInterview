package com.jp.CodingInterview.questions;

// 输入一棵二叉树，判断该二叉树是否是平衡二叉树。

import com.jp.CodingInterview.datastruct.TreeNode;

public class Q55_02_BalancedBinaryTree2 {

    public static class Result{
        public boolean isBalanced;
        public int depth;

        public Result(boolean isBalanced, int depth) {
            this.isBalanced = isBalanced;
            this.depth = depth;
        }
    }

    public static boolean IsBalanced_Solution(TreeNode root){
        return IsBalancedCore(root).isBalanced;
    }

    public static Result IsBalancedCore(TreeNode root){
        if(root==null)
            return new Result(true,0);
        if(root.left==null&&root.right==null)
            return new Result(true,1);
        else{
            Result leftResult = IsBalancedCore(root.left);
            Result rightResult = IsBalancedCore(root.right);
            if(leftResult.isBalanced&&rightResult.isBalanced){
                int diff = leftResult.depth-rightResult.depth;
                if(diff<=1&&diff>=-1){
                    return new Result(true,Math.max(leftResult.depth,rightResult.depth)+1);
                }
            }
            return new Result(false,0);
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
        System.out.println(IsBalanced_Solution(root));
        root = new TreeNode<>(1,node2,new TreeNode<>(3));
        System.out.println(IsBalanced_Solution(root));

    }
}
