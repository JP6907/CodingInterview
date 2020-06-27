package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

public class Q606_ConstructStringfromBinaryTree {

    public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        if(t.left!=null){
            sb.append("(");
            sb.append(tree2str(t.left));
            sb.append(")");
        }
        if(t.right!=null){
            if(t.left==null){
                sb.append("()");
            }
            sb.append("(");
            sb.append(tree2str(t.right));
            sb.append(")");
        }
        return sb.toString();
    }
}
