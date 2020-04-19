package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

//Given two binary trees, write a function to check if they are the same or not.
//Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
public class Q100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
            return true;
        else if(p==null&&q!=null)
            return false;
        else if(p!=null&&q==null)
            return false;
        else if(p.val!=q.val)
            return false;
        else
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
