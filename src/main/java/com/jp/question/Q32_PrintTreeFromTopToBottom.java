package com.jp.question;


import com.jp.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q32_PrintTreeFromTopToBottom {

    // 32（一）：不分行从上往下打印二叉树
    // 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode<Integer> root){
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode<Integer> node = queue.poll();
            list.add(node.key);
            if(node.lchild!=null)
                queue.add(node.lchild);
            if(node.rchild!=null)
                queue.add(node.rchild);
        }
        return list;
    }

    public static void Test(TreeNode<Integer> root){
        ArrayList<Integer> result = PrintFromTopToBottom(root);
        System.out.println(result.toString());
    }

    public static void main(String[] args){
        //            10
        //         /      \
        //        6        14
        //       /\        /\
        //      4  8     12  16
        TreeNode<Integer> node648 = new TreeNode<>(6,4,8);
        TreeNode<Integer> node141216 = new TreeNode<>(14,12,16);
        TreeNode<Integer> root = new TreeNode<>(10,node648,node141216);
        Test(root);

        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2,node1,null);
        TreeNode<Integer> node3 = new TreeNode<>(3,node2,null);
        TreeNode<Integer> node4 = new TreeNode<>(4,node3,null);
        TreeNode<Integer> node5 = new TreeNode<>(5,node4,null);
        Test(node5);
    }

}
