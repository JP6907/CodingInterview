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

    public boolean isSymmetric2(TreeNode root) {
        return isSymmetricCore2(root, root);
    }

    public boolean isSymmetricCore2(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null){
            return true;
        } else if(root1 == null && root2 != null){
            return false;
        } else if(root1 != null && root2 == null){
            return false;
        } else if(root1.val != root2.val){
            return false;
        } else {
            return isSymmetricCore2(root1.left, root2.right) && isSymmetricCore2(root1.right, root2.left);
        }
    }
}
