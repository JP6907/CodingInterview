package com.jp.CodingInterview.questions;

import com.jp.CodingInterview.datastruct.TreeNode;

// 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
// 要求不能创建任何新的结点，只能调整树中结点指针的指向。
// 解题思路：二叉搜索树是有序的，左<根<右
// 使用中序遍历：
// 1. 将左子树转化为链表，连接左链表和根节点组合成为新的链表
// 2. 将右子树转化为链表，连接左链表、根节点、右链表 得到目标链表
public class Q36_ConvertBinarySearchTree2 {

    //辅助类
    //储存已经转化完成的链表的头节点和尾节点
    public static class Nodes{
        public TreeNode<Integer> head;
        public TreeNode<Integer> tail;

        Nodes(TreeNode<Integer> head,TreeNode<Integer> tail){
            this.head = head;
            this.tail = tail;
        }
    }

    public static TreeNode<Integer> Convert(TreeNode<Integer> pRootOfTree){
        if(pRootOfTree==null)
            return null;
        else
            return ConcertCode(pRootOfTree).head;
    }


    public static Nodes ConcertCode(TreeNode<Integer> pRootOfTree){
        if(pRootOfTree!=null){
            Nodes leftNodes = null;
            Nodes rightNodes = null;
            Nodes nodes = new Nodes(pRootOfTree,pRootOfTree);
            //只有一个节点则头尾节点都是当前节点
            if(pRootOfTree.left==null&&pRootOfTree.right==null){
                return nodes;
            }
            if(pRootOfTree.left!=null){
                //递归转化左子树为链表
                leftNodes = ConcertCode(pRootOfTree.left);
                //连接左子树链表和当前节点
                if(leftNodes!=null) {
                    leftNodes.tail.right = pRootOfTree;
                    pRootOfTree.left = leftNodes.tail;
                    nodes.head = leftNodes.head;
                }
            }
            if(pRootOfTree.right!=null){
                //递归转化右子树为链表
                rightNodes = ConcertCode(pRootOfTree.right);
                //连接右子树链表和当前节点
                if(rightNodes!=null) {
                    rightNodes.head.left = pRootOfTree;
                    pRootOfTree.right = rightNodes.head;
                    nodes.tail = rightNodes.tail;
                }
            }
            return nodes;
        }else{
            return null;
        }
    }

    public static void PrintList(TreeNode<Integer> list){
        TreeNode<Integer> p = list;
        while (p!=null){
            System.out.format("%d %d %d\n",(p.left==null)?-1:p.left.val,p.val,(p.right==null)?-1:p.right.val);
            p = p.right;
        }
    }

    public static void main(String[] args){
        //            10
        //         /      \
        //        6        14
        //       /\        /\
        //      4  8     12  16
        TreeNode<Integer> node648 = new TreeNode<>(6,4,8);
        TreeNode<Integer> node141216 = new TreeNode<>(14,12,16);
        TreeNode node10 = new TreeNode(10,node648,node141216);
        //TreeNode.PrintTree(node10);
        TreeNode<Integer> head = Convert(node10);
        //4 6 8 10 12 14 16
        PrintList(head);

        System.out.println("=====================");

        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2,node1,null);
        TreeNode<Integer> node3 = new TreeNode<>(3,node2,null);
        TreeNode<Integer> node4 = new TreeNode<>(4,node3,null);
        TreeNode<Integer> node5 = new TreeNode<>(5,node4,null);
        head = Convert(node5);
        PrintList(head);

        System.out.println("=====================");

        node5 = new TreeNode<>(5);
        node4 = new TreeNode<>(4,null,node5);
        node3 = new TreeNode<>(3,null,node4);
        node2 = new TreeNode<>(2,null,node3);
        node1 = new TreeNode<>(1,null,node2);
        head = Convert(node1);
        PrintList(head);

        System.out.println("=====================");

        TreeNode<Integer> node = new TreeNode<>(100);
        head = Convert(node);
        PrintList(head);

    }
}
