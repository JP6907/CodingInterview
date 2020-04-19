package com.jp.LeetCode.question;


import com.jp.LeetCode.datastruct.TreeNode;

//求完全二叉树节点数量
//暴力法：节点数量=左子树节点数量+右子树节点数量+1
//利用完全二叉树的特点：
//满二叉树一定是完全二叉树，完全二叉数不一定是满二叉树
//如果是满二叉树，直接返回2^n-1
//否则为左子树节点数量+右子树节点数量+1
//递归求左右子树节点数量
public class Q222_CountCompleteTreeNodes {

    public static int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        int left=0,right=0;
        TreeNode pLeft = root;
        TreeNode pRight = root;
        while (pLeft!=null&&pRight!=null){
            left++;
            right++;
            pLeft = pLeft.left;
            pRight = pRight.right;
        }
        if(pLeft==null&&pRight==null)
            return (int)Math.pow(2,left)-1;
        else
            return countNodes(root.left)+countNodes(root.right)+1;
    }

    public static void test(TreeNode root,int expected){
        System.out.println(countNodes(root)==expected);
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2,4,5);
        TreeNode node3 = new TreeNode(3,new TreeNode(6),null);
        TreeNode root = new TreeNode(1,node2,node3);
        test(root,6);
    }
}
