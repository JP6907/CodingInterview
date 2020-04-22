package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

public class Q538_ConvertBSTtoGreaterTree {

    //中序遍历反过来
    //右根左
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root!=null){
            convertBST(root.right);
            root.val += sum;
            sum = root.val;
            convertBST(root.left);
            return root;
        }else {
            return null;
        }
    }

}
