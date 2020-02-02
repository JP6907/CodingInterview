package com.jp.question;


import com.jp.datastruct.TreeNode;

// 面试题54：二叉搜索树的第k个结点
// 题目：给定一棵二叉搜索树，请找出其中的第k大的结点。

public class Q54_KthNodeInBST {
    static int index = 0;
    static TreeNode<Integer> KthNode(TreeNode<Integer> pRoot, int k){
        if(pRoot!=null){
            TreeNode<Integer> result = KthNode(pRoot.lchild,k);
            if(result!=null)
                return result;
            if(++index==k)
                return pRoot;
            result = KthNode(pRoot.rchild,k);
            return result;
        }
        return null;
    }


    static TreeNode<Integer> KthNode2(TreeNode<Integer> root, int k){
        if(root!=null){
            TreeNode<Integer> result = KthNode2(root.left,k);
            if(result!=null)
                return result;
            if(++index==k)
                return root;
            else
                return KthNode2(root.right,k);
        }
        return null;
    }

    public static void main(String[] args){
        TreeNode<Integer> node234 = new TreeNode<Integer>(2,3,4);
        TreeNode<Integer> node678 = new TreeNode<Integer>(6,7,8);
        TreeNode<Integer> root = new TreeNode<Integer>(5,node234,node678);
        System.out.println(KthNode(root,3));
    }
}
