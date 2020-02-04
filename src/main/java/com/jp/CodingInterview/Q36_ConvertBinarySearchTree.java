package com.jp.CodingInterview;

import com.jp.datastruct.TreeNode;

// 面试题36：二叉搜索树与双向链表
// 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
// 要求不能创建任何新的结点，只能调整树中结点指针的指向。
// 需要转化成排序的双向链表，因此考虑中序遍历
// 按照中序遍历的思想，当遍历到根节点的时候，它的左子树已经转化成一个排序的链表
// 并且处在链表最后的一个节点是当前的最大节点
// 接着去遍历右子树
// 把根节点和左子树的最大节点和右子树的最小节点连接起来
// 递归
public class Q36_ConvertBinarySearchTree {

    /**
     *
     * @param root 根节点
     * @param lastNodeInList 当前已经转化好的链表最后一个节点
     * @return 返回新的 lastNodeInList，参数中的lastNodeInList传入的是引用的拷贝值，无法通过参数返回
     */
    static TreeNode<Integer> convertNode(TreeNode<Integer> root){
        if(root==null)
            return null;
        TreeNode<Integer> newLastNodeInLeftList = null;
        TreeNode<Integer> newLastNodeInRightList = null;

        TreeNode<Integer> current = root;
        //转化左子树
        if(current.lchild!=null)
            newLastNodeInLeftList = convertNode(current.lchild);
        //连接左子树
        current.lchild = newLastNodeInLeftList;
        if(newLastNodeInLeftList!=null)
            newLastNodeInLeftList.rchild = current;
        //转化右子树
        if(current.rchild!=null) {
            newLastNodeInRightList = convertNode(current.rchild);
            TreeNode<Integer> node = newLastNodeInRightList;
            while (node!=current.rchild)
                node = node.lchild;

            node.lchild = current;
            current.rchild = node;
        }

        return newLastNodeInRightList;
    }


    static TreeNode<Integer> convert(TreeNode<Integer> root){
        //convertNode函数不能传入一个null，否则修改的链表无法被lastNodeInList接收
        //将lastNodeInList设置为一个任意值，该节点会被插入到转化后链表的开头，去除第一个节点即可

        TreeNode<Integer> lastNodeInList = convertNode(root);

        TreeNode<Integer> head = lastNodeInList;
        while (head!=null && head.lchild!=null)
            head = head.lchild;

        return head;
    }

    public static void main(String[] args){
        TreeNode<Integer> node648 = new TreeNode<Integer>(6,4,8);
        TreeNode<Integer> node141216 = new TreeNode<Integer>(14,12,16);
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.setLchild(node648);
        root.setRchild(node141216);
        TreeNode<Integer> head = convert(root);
        while (head!=null) {
            System.out.print(head.key + " ");
            head = head.rchild;
        }
        System.out.println();
    }

}
