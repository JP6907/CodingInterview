package com.jp.CodingInterview.questions;

// 请实现一个函数，用来判断一颗二叉树是不是对称的。
// 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

import com.jp.CodingInterview.datastruct.TreeNode;

public class Q28_SymmetricalBinaryTree {

    //方法一. 生成镜像，判断原像和镜像是否一致
    //方法二. LNR=RNL 前序遍历和后序遍历结果一致 或 LRN=RLN
    //方法三. 比较left==right
    public static boolean isSymmetrical(TreeNode pRoot){
        return isSymmetricalCore(pRoot,pRoot);
    }

    public static boolean isSymmetricalCore(TreeNode pRoot1,TreeNode pRoot2){
        if(pRoot1==null&&pRoot2==null)
            return true;
        else if(pRoot1!=null&&pRoot2!=null&&pRoot1.val==pRoot2.val){
            return isSymmetricalCore(pRoot1.left,pRoot2.right)&&
                    isSymmetricalCore(pRoot1.right,pRoot2.left);
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        //            8
        //        6      6
        //       5 7    7 5
        TreeNode<Integer> node61 = new TreeNode<>(6,5,7);
        TreeNode<Integer> node62 = new TreeNode<>(6,new TreeNode<Integer>(7),null);
        TreeNode<Integer> node8 = new TreeNode<>(8,node61,node62);
        System.out.println(isSymmetrical(node8));
    }
}
