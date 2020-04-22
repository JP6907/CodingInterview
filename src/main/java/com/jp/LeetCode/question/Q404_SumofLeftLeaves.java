package com.jp.LeetCode.question;

//Find the sum of all left leaves in a given binary tree.
//
//Example:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

import com.jp.LeetCode.datastruct.TreeNode;

public class Q404_SumofLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        sumOfLeftLevelsCore(null,root);
        return sum;
    }

    int sum = 0;
    public void sumOfLeftLevelsCore(TreeNode parent,TreeNode curr){
        if(curr==null)
            return;
        if(curr.left==null&&curr.right==null){
            if(parent!=null&&curr==parent.left)
                sum += curr.val;
        }else {
            sumOfLeftLevelsCore(curr,curr.left);
            sumOfLeftLevelsCore(curr,curr.right);
        }
    }
}

