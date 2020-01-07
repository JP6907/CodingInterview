package com.jp.datastruct;

public class BSTree<T extends Comparable<T>> {

    private TreeNode root;

    public class TreeNode<T> {

        public T key;
        public TreeNode lchild;
        public TreeNode rchild;

        public TreeNode(T key,TreeNode<T> lchild,TreeNode<T> rchild) {
            super();
            this.key = key;
            this.lchild = lchild;
            this.rchild = rchild;
        }

        @Override
        public String toString() {
            return String.valueOf(this.key);
        }

    }


    private TreeNode<T> insert(TreeNode<T> node,T key) {
        if(node==null){
            node = new TreeNode<T>(key,null,null);
        }else{
            int cmp = key.compareTo(node.key);
            if(cmp<0){
                node.lchild = insert(node.lchild,key);
            }else if(cmp>0){
                node.rchild = insert(node.rchild,key);
            }
        }
        return node;
    }

    public void insert(T key){
        this.root = insert(this.root,key);
    }

    private TreeNode search(TreeNode<T> node,T key) {
        if(node!=null) {
            int cmp = key.compareTo(node.key);
            if(cmp<0)
                return search(node.lchild,key);
            else if(cmp>0)
                return search(node.rchild,key);
            else
                return node;
        }else
            return null;
    }
    /**
     * 二叉查找树删除
     * 如果没有子树，直接删除
     * 如果只有一个子树，直接删除，用子树代替
     * 如果有两个子树，直接删除，，用直接前驱代替，即用左子树的最大值代替
     * @param tree
     * @param deleteNode
     */
    private TreeNode<T> remove(TreeNode<T> tree,TreeNode<T> deleteNode) {
        if(tree==null||deleteNode==null)
            return null;
        else{
            int cmp = deleteNode.key.compareTo(tree.key);
            if(cmp<0){
                tree.lchild = remove(tree.lchild,deleteNode);
            }else if(cmp>0){
                tree.rchild = remove(tree.rchild,deleteNode);
            }else{
                if(tree.lchild!=null&&tree.rchild!=null){
                    TreeNode<T> lmaxnode = maxNode(tree.lchild);
                    tree.key = lmaxnode.key;
                    tree.lchild = remove(tree.lchild,lmaxnode);
                }else{
                    tree = tree.lchild!=null?tree.lchild:tree.rchild;
                }
            }
            return tree;
        }
    }

    public void remove(T key){
        TreeNode<T> node = search(this.root,key);
        if(node!=null)
            remove(this.root,node);
    }

    /**
	 * 寻找二叉树中的最大值
	 * @param T
	 * @return
	 */
    private TreeNode<T> maxNode(TreeNode<T> node){

        if(node!=null){
            if(node.rchild!=null)
                return maxNode(node.rchild);
            else
                return node;
        }else
            return null;
    }
    //	/**
//	 * 中序遍历二叉树
//	 * @param T
//	 */
    private void InOrderTraversal(TreeNode<T> node) {
        if(node!=null) {
            InOrderTraversal(node.lchild);
            System.out.println("InOrder:" + node.key);
            InOrderTraversal(node.rchild);
        }
    }

    public void InOrderTraversal(){
        InOrderTraversal(this.root);
    }

    public static void main(String[] args) {
        int[] data = {3,1,8,2,6,7,5};
        BSTree<Integer> tree = new BSTree<Integer>();
        for(int i=0;i<data.length;i++)
            tree.insert(data[i]);

        tree.InOrderTraversal();

        System.out.println();
        tree.remove(6);
        tree.InOrderTraversal();
        System.out.println(tree.maxNode(tree.root));
    }

}