package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

public class Q101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null))
            return true;
        else if(root.left==null||root.right==null)
            return false;
        else
            return isSymmetricCore(root.left,root.right);
    }

    public boolean isSymmetricCore(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null)
            return true;
        else if(node1==null&&node2!=null)
            return false;
        else if(node1!=null&&node2==null)
            return false;
        else if(node1.val!=node2.val)
            return false;
        else
            return isSymmetricCore(node1.left,node2.right)&&isSymmetricCore(node1.right,node2.left);
    }
}
