package com.jp.CodingInterview;

// 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
// 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

public class Q08_NextNodeInBinaryTrees {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static void ConnectNode(TreeLinkNode parent,TreeLinkNode left,TreeLinkNode right){
        parent.left = left;
        parent.right = right;
        left.next = parent;
        right.next = parent;
    }

    // LNR
    public static TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode==null)
            return null;
        //如果右子树不为空，返回右子树的最左节点
        if(pNode.right!=null){
            TreeLinkNode next = pNode.right;
            while (next.left!=null)
                next = next.left;
            return next;
        }else{
            //如果右子树为空，
            TreeLinkNode parent = pNode.next;
            if(parent==null) //父节点为空
                return null;
            //  如果是左子节点，返回父节点
            if(pNode==parent.left)
                return parent;
            //  如果是右子节点
            else{
                //    不断往上寻找，找到一个节点，是其父节点的左子节点，返回这个父节点
                //    如果父节点是左子节点，返回父节点的父节点
                //    如果父节点是右子节点，不断往上找到为左子节点祖父节点，返回祖父节点的父节点
                TreeLinkNode pparent = parent.next;
                while (pparent!=null&&parent==pparent.right){
                    parent = pparent;
                    pparent = pparent.next;
                }
                return pparent;
            }
        }
    }

    public static void main(String[] args){
        //            8
        //        6      10
        //       5 7    9  11
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        TreeLinkNode node8 = new TreeLinkNode(8);
        TreeLinkNode node9 = new TreeLinkNode(9);
        TreeLinkNode node10 = new TreeLinkNode(10);
        TreeLinkNode node11 = new TreeLinkNode(11);
        ConnectNode(node8,node6,node10);
        ConnectNode(node6,node5,node7);
        ConnectNode(node10,node9,node11);
        System.out.println(GetNext(node8)==node9);
        System.out.println(GetNext(node6)==node7);
        System.out.println(GetNext(node10)==node11);
        System.out.println(GetNext(node5)==node6);
        System.out.println(GetNext(node7)==node8);
        System.out.println(GetNext(node9)==node10);
        System.out.println(GetNext(node11)==null);
    }

}