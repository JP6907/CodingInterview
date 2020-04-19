package com.jp.LeetCode.question;


import com.jp.LeetCode.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q145_BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        postOrder(root,result);
        return result;
    }

    public void postOrder(TreeNode root, List<Integer> result){
        if(root!=null){
            postOrder(root.left,result);
            postOrder(root.right,result);
            result.add(root.val);
        }
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        class MarkNode{
            TreeNode node;
            int mark;

            public MarkNode(TreeNode node, int mark) {
                this.node = node;
                this.mark = mark;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        Stack<MarkNode> stack = new Stack<MarkNode>();
        TreeNode p = root;
        while (p!=null||!stack.empty()){
            while (p!=null){
                stack.push(new MarkNode(p,1));
                p = p.left;
            }
            if(!stack.empty()){
                MarkNode mnode = stack.pop();
                p = mnode.node;
                if(mnode.mark==1){
                    stack.push(new MarkNode(p,2));
                    p = p.right;
                }else {
                    result.add(p.val);
                    p = null;
                }
            }
        }
        return result;
    }
}
