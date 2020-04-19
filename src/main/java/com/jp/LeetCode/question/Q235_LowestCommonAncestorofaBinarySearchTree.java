package com.jp.LeetCode.question;


import com.jp.LeetCode.datastruct.TreeNode;

public class Q235_LowestCommonAncestorofaBinarySearchTree {

    //DFS找到到达两个节点的路径
    //用stack储存
    //利用二叉搜索树的特性
    //从上往下寻找到第一个符合：left<root<right的root的节点
    //递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val&&root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        else if(root.val<p.val&&root.val<q.val)
            return lowestCommonAncestor(root.right,p,q);
        else
            return root;
    }

    //非递归
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
        TreeNode node = root;
        while (true){
            if(node.val>p.val&&node.val>q.val)
                node = node.left;
            else if(node.val<p.val&&node.val<q.val)
                node = node.right;
            else
                break;
        }
        return node;
    }
}
