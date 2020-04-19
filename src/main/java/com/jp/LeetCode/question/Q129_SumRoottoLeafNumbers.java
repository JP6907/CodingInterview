package com.jp.LeetCode.question;


import com.jp.LeetCode.datastruct.TreeNode;

public class Q129_SumRoottoLeafNumbers {

    static int sum = 0;
    public static int sumNumbers(TreeNode root) {
        sumCore(root,0);
        return sum;
    }

    public static void sumCore(TreeNode root,int current){
        if(root==null)
            return;
        current = current*10 + root.val;
        if(root.left==null&&root.right==null){
            sum += current;
        }else {
            if(root.left!=null)
                sumCore(root.left,current);
            if(root.right!=null)
                sumCore(root.right,current);
        }
    }
}
