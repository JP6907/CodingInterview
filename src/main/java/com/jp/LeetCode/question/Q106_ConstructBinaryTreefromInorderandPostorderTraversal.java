package com.jp.LeetCode.question;


import com.jp.LeetCode.datastruct.TreeNode;

//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3]
//Return the following binary tree:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
public class Q106_ConstructBinaryTreefromInorderandPostorderTraversal {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0||postorder.length==0||inorder.length!=postorder.length)
            return null;
        return buildTreeCore(inorder,0,inorder.length-1,postorder,0,postorder.length-1);

    }

    public static TreeNode buildTreeCore(int[] inorder,int inLeft,int inRight,int[] postorder,int postLeft,int postRight) {
        if(inLeft>inRight||postLeft>postRight)
            return null;
        TreeNode root = new TreeNode(postorder[postRight]);
        if(inLeft==inRight)
            return root;
        int rootInInorder = inLeft;
        while (rootInInorder<=inRight&&inorder[rootInInorder]!=postorder[postRight])
            rootInInorder++;
        int leftSize = rootInInorder-inLeft;
        int rightSize = inRight-rootInInorder;
        root.left = buildTreeCore(inorder,inLeft,inLeft+leftSize-1,postorder,postLeft,postLeft+leftSize-1);
        root.right = buildTreeCore(inorder,rootInInorder+1,inRight,postorder,postLeft+leftSize,postRight-1);
        return root;
    }


    public static void main(String[] args) {
        TreeNode result = buildTree(new int[]{9,3,15,20,7},new int[]{9,15,7,20,3});
        TreeNode.PrintTree(result);

    }
}
