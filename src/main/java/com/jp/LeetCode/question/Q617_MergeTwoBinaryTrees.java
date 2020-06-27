package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

public class Q617_MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null)
            return null;
        TreeNode merge = new TreeNode(0);
        mergeTreeCore(t1,t2,merge);
        return merge;
    }

    public void mergeTreeCore(TreeNode t1,TreeNode t2,TreeNode merge){
        if(t1!=null&&t2!=null){
            merge.val = t1.val + t2.val;
        }else if(t1!=null){
            merge.val = t1.val;
        }else if(t2!=null){
            merge.val =  t2.val;
        }
        TreeNode left1 = (t1!=null&&t1.left!=null?t1.left:null);
        TreeNode left2 = (t2!=null&&t2.left!=null?t2.left:null);
        if(left1!=null||left2!=null){
            merge.left = new TreeNode(0);
            mergeTreeCore(left1,left2,merge.left);
        }
        TreeNode right1 = (t1!=null&&t1.right!=null?t1.right:null);
        TreeNode right2 = (t2!=null&&t2.right!=null?t2.right:null);
        if(right1!=null||right2!=null){
            merge.right = new TreeNode(0);
            mergeTreeCore(right1,right2,merge.right);
        }
    }
}
