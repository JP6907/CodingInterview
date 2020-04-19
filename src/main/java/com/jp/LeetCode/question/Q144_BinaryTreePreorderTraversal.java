package com.jp.LeetCode.question;


import com.jp.LeetCode.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q144_BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preOrder(root,result);
        return result;
    }

    public void preOrder(TreeNode root,List<Integer> result){
        if(root!=null){
            result.add(root.val);
            preOrder(root.left,result);
            preOrder(root.right,result);
        }
    }
}
