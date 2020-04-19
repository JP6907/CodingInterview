package com.jp.LeetCode.question;



import com.jp.LeetCode.datastruct.TreeNode;

import java.util.Stack;

public class Q236_LowestCommonAncestorofaBinaryTree {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //用两个栈记录路劲
        Stack<TreeNode> path1 = new Stack<TreeNode>();
        Stack<TreeNode> path2 = new Stack<TreeNode>();
        getPath(root,p,path1);
        getPath(root,q,path2);
        if(path1.size()>path2.size()){
            Stack<TreeNode> temp = path1;
            path1 = path2;
            path2 = temp;
        }
        //path1小
        while (path1.size()<path2.size())
            path2.pop();
        TreeNode lca = null;
        while (!path1.empty()){
            TreeNode node1 = path1.pop();
            TreeNode node2 = path2.pop();
            if(node1==node2){
                lca = node1;
                break;
            }
        }
        return lca;
    }

    public static boolean getPath(TreeNode root, TreeNode target,Stack<TreeNode> path){
        if(root==null)
            return false;
        path.push(root);
        if(root==target)
            return true;
        boolean result = getPath(root.left,target,path)||getPath(root.right,target,path);
        if(result)
            return true;
        else {
            path.pop();
            return false;
        }
    }

    public static void test(TreeNode root,TreeNode p,TreeNode q,TreeNode expected){
        System.out.println(lowestCommonAncestor(root,p,q)==expected);
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2,null,null);
        TreeNode root = new TreeNode(1,node2,null);
        test(root,node2,root,root);
    }
}
