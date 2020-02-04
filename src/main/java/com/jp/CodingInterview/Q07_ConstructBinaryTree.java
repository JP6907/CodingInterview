package com.jp.CodingInterview;

// 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
// 则重建二叉树并返回。

import com.jp.datastruct.TreeNode;

public class Q07_ConstructBinaryTree {

    public static TreeNode<Integer> reConstructBinaryTree(int[] pre,int[] in){
        if(pre.length!=in.length)
            return null;
        return reConstructBinaryTreeCore(pre,0,pre.length-1,
                                            in,0,in.length-1);
    }

    public static TreeNode<Integer> reConstructBinaryTreeCore(int[] pre,int preLeft,int preRight,
                                                                int[] in,int inLeft,int inRight){
        if(preLeft>preRight||inLeft>inRight)
            return null;
        //前序遍历第一个节点是根节点
        int rootData = pre[preLeft];
        TreeNode<Integer> root = new TreeNode<>(rootData);
        //只有一个节点
        if(preLeft==preRight)
            return root;

        for(int i=inLeft;i<=inRight;i++){
            if(in[i]==rootData){  //在中序遍历中找到根节点，根据根节点切分左右子树
                // 使用中序遍历的根节点的索引可以得出左右长度
                // leftLength = i-inLeft
                // preLeft+1 -> preLeft+1 + i-inLeft
                int leftLength = i-inLeft;
                int rightLength = inRight-i;
                if(leftLength>0)
                    root.setLchild(reConstructBinaryTreeCore(pre,preLeft+1,preLeft+1+leftLength-1,
                                                            in,inLeft,i-1));
                if(rightLength>0)
                    root.setRchild(reConstructBinaryTreeCore(pre,preLeft+leftLength+1,preRight,
                                                            in,i+1,inRight));
                break;
            }
        }
        return root;
    }
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    public static void Test1(){
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode<Integer> root = reConstructBinaryTree(preorder,inorder);
        TreeNode.PrintTree(root);
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    public static void Test2(){
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        TreeNode<Integer> root = reConstructBinaryTree(preorder,inorder);
        TreeNode.PrintTree(root);
    }

    public static void main(String[] args){
        Test1();
        Test2();
    }
}
