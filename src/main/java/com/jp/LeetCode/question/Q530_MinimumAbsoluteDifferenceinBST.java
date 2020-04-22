package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

//中序遍历
public class Q530_MinimumAbsoluteDifferenceinBST {


    public int getMinimumDifference(TreeNode root) {
        inOrderTraverse(root);
        return minDiff;
    }

    TreeNode pre = null;
    int minDiff = Integer.MAX_VALUE;
    public void inOrderTraverse(TreeNode root){
        if(root!=null){
            inOrderTraverse(root.left);
            if(pre!=null){
                minDiff = Math.min(minDiff,root.val-pre.val);
            }
            pre = root;
            inOrderTraverse(root.right);
        }
    }
}
