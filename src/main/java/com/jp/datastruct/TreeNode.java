package com.jp.datastruct;

public class TreeNode<T> {
    public T key;
    public TreeNode lchild;
    public TreeNode rchild;

    public TreeNode(T key) {
        this.key = key;
        this.lchild = null;
        this.rchild = null;
    }

    public TreeNode(T key,T left,T right) {
        this.key = key;
        this.lchild = new TreeNode(left);
        this.rchild = new TreeNode(right);
    }

    public TreeNode(T key, TreeNode<T> lchild, TreeNode<T> rchild) {
        super();
        this.key = key;
        this.lchild = lchild;
        this.rchild = rchild;
    }


    public T getKey() {
        return key;
    }

    public void setKey(T key) {
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

    public static void  PrintTree(TreeNode root){
        PrintTreeNode(root);
        if(root!=null){
            if(root.lchild!=null)
                PrintTree(root.lchild);
            if(root.rchild!=null)
                PrintTree(root.rchild);
        }
    }

    public static void main(String[] args){
        TreeNode<Integer> node123 = new TreeNode<>(1,2,3);
        TreeNode<Integer> node456 = new TreeNode<>(4,5,6);
        TreeNode<Integer> root = new TreeNode<Integer>(0,node123,node456);
        TreeNode.PrintTree(root);
    }
}
