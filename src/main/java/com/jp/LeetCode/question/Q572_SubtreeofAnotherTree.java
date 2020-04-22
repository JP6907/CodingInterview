package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

public class Q572_SubtreeofAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(isSame(s,t)) {
            return true;
        }else {
            boolean result = false;
            if(s!=null&&s.left!=null)
                result = isSubtree(s.left,t);
            if(result)
                return true;
            if(s!=null&&s.right!=null)
                result = isSubtree(s.right,t);
            return result;
        }
    }

    public boolean isSame(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null) {
            return true;
        }else if(node1==null||node2==null){
            return false;
        }else {
            if(node1.val!=node2.val){
                return false;
            }else {
                return isSame(node1.left,node2.left)&&isSame(node1.right,node2.right);
            }
        }
    }
}
