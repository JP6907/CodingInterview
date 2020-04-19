package com.jp.LeetCode.question;

//Given a binary tree, return the inorder traversal of its nodes' values.
//
//Example:
//
//Input: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//Output: [1,3,2]
//Follow up: Recursive solution is trivial, could you do it iteratively?

import com.jp.LeetCode.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Q94_BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p!=null||!stack.empty()){
            while (p!=null){
                stack.push(p);
                p = p.left;
            }
            if(!stack.empty()){
                p = stack.pop();
                result.add(p.val);
                p = p.right;
            }
        }
        return result;
    }

    public static void test(TreeNode root){
        List<Integer> result = inorderTraversal(root);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public static void main(String[] args) {
        TreeNode node23 = new TreeNode(2,new TreeNode(3),null);
        TreeNode root = new TreeNode(1,null,node23);
        test(root);
    }

}
