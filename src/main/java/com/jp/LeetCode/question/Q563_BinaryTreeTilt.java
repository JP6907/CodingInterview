package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

public class Q563_BinaryTreeTilt {

    public int findTilt(TreeNode root) {
        postOrderTraverse(root);
        return tilt;
    }

    //后序遍历，求左右子树节点的和
    int tilt = 0;
    public int postOrderTraverse(TreeNode root){
        if(root!=null){
            int left = postOrderTraverse(root.left);
            int right = postOrderTraverse(root.right);
            tilt += Math.abs(left-right);
            return left + right + root.val;
        }else {
            return 0;
        }
    }

    public void test(){
        //      1
        //     / \
        //    2   3
        //   /   /
        //  4   5
        TreeNode node2 = new TreeNode(2,new TreeNode(4),null);
        TreeNode node3 = new TreeNode(3,new TreeNode(5),null);
        TreeNode root = new TreeNode(1,node2,node3);
        System.out.println(findTilt(root));
    }

    public static void main(String[] args) {
        new Q563_BinaryTreeTilt().test();
    }
}
