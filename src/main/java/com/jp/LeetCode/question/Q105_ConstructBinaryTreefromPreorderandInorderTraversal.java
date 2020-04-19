package com.jp.LeetCode.question;


import com.jp.LeetCode.datastruct.TreeNode;

//preorder = [3,9,20,15,7]
//inorder = [9,3,15,20,7]
//Return the following binary tree:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
public class Q105_ConstructBinaryTreefromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length!=inorder.length)
            return null;
        return buildTreeCore(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode buildTreeCore(int[] preorder,int preLeft,int preRight,int[] inorder,int inLeft,int inRight){
        if(preorder.length==0||inorder.length==0||preLeft>preRight||inLeft>inRight)
            return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        int rootInInorder = inLeft;//根节点在中序遍历中的位置
        while (rootInInorder<=inRight&&inorder[rootInInorder]!=preorder[preLeft]){
            rootInInorder++;
        }
        int leftSize = rootInInorder-inLeft; //左子树的节点数量
        int rightSize =  inRight-rootInInorder;//右子树的节点数量
        root.left = buildTreeCore(preorder,preLeft+1,preLeft+leftSize,inorder,inLeft,rootInInorder-1);
        root.right = buildTreeCore(preorder,preLeft+leftSize+1,preRight,inorder,rootInInorder+1,inRight);
        return root;
    }

}
