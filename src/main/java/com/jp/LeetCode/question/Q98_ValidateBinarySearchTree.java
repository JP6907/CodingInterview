package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

import java.util.Stack;

//Given a binary tree, determine if it is a valid binary search tree (BST).
//
//Assume a BST is defined as follows:
//
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.
//
//
//Example 1:
//
//    2
//   / \
//  1   3
//
//Input: [2,1,3]
//Output: true
//Example 2:
//
//    5
//   / \
//  1   4
//     / \
//    3   6
//
//Input: [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
public class Q98_ValidateBinarySearchTree {

    static double pre = -Double.MAX_VALUE;

    //中序优先遍历
    //递归
    public static boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        boolean result = true;
        if(root.left!=null)
            result = isValidBST(root.left);
        if(!result)
            return false;
        if(pre>=root.val)
            return false;
        pre = root.val;
        return isValidBST(root.right);

    }

    //非递归
    public static boolean isValidBST2(TreeNode root) {
        double pre = -Double.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (!stack.empty()||p!=null){
            while (p!=null){
                stack.push(p);
                p = p.left;
            }
            if(!stack.empty()){
                p = stack.pop();
                if(pre>=p.val)
                    return false;
                pre = p.val;
                p = p.right;
            }
        }
        return true;
    }


    public static void test(TreeNode root,boolean expected){
        pre = Integer.MIN_VALUE;
        System.out.println(isValidBST(root)==expected);
        System.out.println(isValidBST2(root)==expected);
    }

    public static void main(String[] args) {
        TreeNode node213 = new TreeNode(2,1,3);
        test(node213,true);

        TreeNode node436 = new TreeNode(4,3,6);
        TreeNode node514 = new TreeNode(5,new TreeNode(1),node436);
        test(node514,false);

        TreeNode node15620 = new TreeNode(15,6,20);
        TreeNode node10 = new TreeNode(10,new TreeNode(5),node15620);
        test(node10,false);
    }
}
