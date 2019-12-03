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
}
