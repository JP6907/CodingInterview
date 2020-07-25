package com.jp.LeetCode.datastruct;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    public int key;
    public TreeNode lchild;
    public TreeNode rchild;

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
        this.lchild = null;
        this.rchild = null;

        this.val = key;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int key,int left,int right) {
        this.key = key;
        this.lchild = new TreeNode(left);
        this.rchild = new TreeNode(right);

        this.val = key;
        this.left = new TreeNode(left);
        this.right = new TreeNode(right);
    }

    public TreeNode(int key, TreeNode lchild, TreeNode rchild) {
        super();
        this.key = key;
        this.lchild = lchild;
        this.rchild = rchild;

        this.val = key;
        this.left = lchild;
        this.right = rchild;
    }


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public TreeNode getLchild() {
        return lchild;
    }

    public void setLchild(TreeNode lchild) {
        this.lchild = lchild;
    }

    public TreeNode getRchild() {
        return rchild;
    }

    public void setRchild(TreeNode rchild) {
        this.rchild = rchild;
    }

    @Override
    public String toString() {
        return String.valueOf(this.key);
    }

    public static void PrintTreeNode(TreeNode root){
        if(root!=null){
            System.out.format("value of this node is: %d\n", root.key);
            if(root.lchild != null)
                System.out.format("value of its left child is: %d.\n", root.lchild.key);
            else
                System.out.format("left child is nullptr.\n");

            if(root.rchild != null)
                System.out.format("value of its right child is: %d.\n", root.rchild.key);
            else
                System.out.format("right child is nullptr.\n");
        }else{
            System.out.format("this node is nullptr.\n");
        }
        System.out.println();
    }

    public static void PrintTreeNode2(TreeNode root){
        if(root!=null){
            System.out.format("value of this node is: %d\n", root.key);
            if(root.left != null)
                System.out.format("value of its left child is: %d.\n", root.left.key);
            else
                System.out.format("left child is nullptr.\n");

            if(root.right != null)
                System.out.format("value of its right child is: %d.\n", root.right.key);
            else
                System.out.format("right child is nullptr.\n");
        }else{
            System.out.format("this node is nullptr.\n");
        }
        System.out.println();
    }

    public static void  PrintTree(TreeNode root){
        PrintTreeNode(root);
        if(root!=null){
            if(root.lchild!=null)
                PrintTree(root.lchild);
            if(root.rchild!=null)
                PrintTree(root.rchild);
        }
    }

    public static void  PrintTree2(TreeNode root){
        PrintTreeNode2(root);
        if(root!=null){
            if(root.left!=null)
                PrintTree2(root.left);
            if(root.right!=null)
                PrintTree2(root.right);
        }
    }

    public static void visit(TreeNode node){
        System.out.print(node.val + "  ");
    }

    public static void PreOrderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()){
            while (p != null){
                visit(p);
                stack.push(p);
                p = p.left;
            }
            if(!stack.empty()){
                p = stack.pop();
                p = p.right;
            }
        }
        System.out.println("-------------");
    }

    public static void InOrderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!= null || !stack.empty()){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            if(!stack.empty()){
                p = stack.pop();
                visit(p);
                p = p.right;
            }
        }
        System.out.println("-------------");
    }

    public static void PostOrderTraversal(TreeNode root){
        class MarkNode{
            public TreeNode node;
            public int mark;

            public MarkNode(TreeNode node, int mark) {
                this.node = node;
                this.mark = mark;
            }
        }
        Stack<MarkNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()){
            while (p != null){
                stack.push(new MarkNode(p, 1));
                p = p.left;
            }
            if(!stack.empty()){
                MarkNode mn = stack.pop();
                if(mn.mark == 1){
                    mn.mark = 2;
                    stack.push(mn);
                    p = mn.node.right;
                } else {
                    visit(mn.node);
                    p = null;
                }
            }
        }
        System.out.println("-------------");
    }

    public static void LevelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode p = root;
        while (!queue.isEmpty()){
            p = queue.poll();
            visit(p);
            if(p.left != null){
                queue.add(p.left);
            }
            if(p.right != null){
                queue.add(p.right);
            }
        }
    }


    public static void main(String[] args){
        TreeNode node123 = new TreeNode(1,2,3);
        TreeNode node456 = new TreeNode(4,5,6);
        TreeNode root = new TreeNode(0,node123,node456);
        //TreeNode.PrintTree(root);

        PreOrderTraversal(root);
        InOrderTraversal(root);
        PostOrderTraversal(root);
        LevelOrderTraversal(root);

        System.out.println("=============");
    }
}