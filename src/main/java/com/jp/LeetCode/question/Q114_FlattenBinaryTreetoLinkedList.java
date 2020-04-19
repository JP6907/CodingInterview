package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

//Given a binary tree, flatten it to a linked list in-place.
//
//For example, given the following tree:
//
//    1
//   / \
//  2   5
// / \   \
//3   4   6
//The flattened tree should look like:
//
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
//前序遍历
public class Q114_FlattenBinaryTreetoLinkedList {

    public static void flatten(TreeNode root) {
        if(root==null)
            return;
        if(root.left!=null)
            flatten(root.left);
        if(root.right!=null)
            flatten(root.right);
        //root - left - right
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode p = root;
        while (p.right!=null)
            p = p.right;
        p.right = temp;
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2,3,4);
        TreeNode node5 = new TreeNode(5,null,new TreeNode(6));
        TreeNode root = new TreeNode(1,node2,node5);
        flatten(root);
        TreeNode p = root;
        while (p!=null){
            System.out.print(p.val+" ");
            p = p.right;
        }
        System.out.println();
    }

}
