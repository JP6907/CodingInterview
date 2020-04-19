package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

import java.util.Stack;

//寻找二叉搜索树种第K小的元素
public class Q230_KthSmallestElementinaBST {

    //中序遍历
    //非递归方式
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int count = 0;
        while (!stack.empty()||p!=null){
            while (p!=null){
                stack.push(p);
                p = p.left;
            }
            if(!stack.empty()){
                p = stack.pop();
                if(++count==k)
                    return p.val;
                p = p.right;
            }
        }
        return Integer.MAX_VALUE;
    }


}