package com.jp.question;

// 面试题55（二）：平衡二叉树
// 题目：输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中
// 任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

import com.jp.datastruct.BSTree;
import com.jp.datastruct.TreeNode;

public class Q55_02_BalancedBinaryTree {

    public static class Result{
        public int depth;
        public boolean isBalanced;

        public Result(int depth, boolean isBalanced) {
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
    }

    static Result isBalanced(TreeNode<Integer> root){
        if(root==null)
            return new Result(0,true);
        Result left = isBalanced(root.lchild);
        Result right = isBalanced(root.rchild);
        if(left.isBalanced&&right.isBalanced){
            int dist = left.depth - right.depth;
            if(dist>1||dist<-1)
                return new Result(-1,false);
            else{
                int depth = left.depth>right.depth?left.depth+1:right.depth+1;
                return new Result(depth,true);
            }
        }else
            return new Result(-1,false);
    }

    public static void main(String[] args){
        TreeNode<Integer> node234 = new TreeNode<Integer>(2,3,4);
        TreeNode<Integer> node678 = new TreeNode<Integer>(6,7,8);
        TreeNode<Integer> root = new TreeNode<Integer>(5,node234,node678);
        System.out.println(isBalanced(root).isBalanced);
        TreeNode<Integer> root2 = new TreeNode<Integer>(5,node234,null);
        System.out.println(isBalanced(root2).isBalanced);
    }
}
