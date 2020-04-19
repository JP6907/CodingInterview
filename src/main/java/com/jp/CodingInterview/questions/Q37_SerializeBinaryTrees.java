package com.jp.CodingInterview.questions;

// 请实现两个函数，分别用来序列化和反序列化二叉树
//
//二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
// 从而使得内存中建立起来的二叉树可以持久保存。
// 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
// 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
//
//二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。

import com.jp.CodingInterview.datastruct.TreeNode;

public class Q37_SerializeBinaryTrees {
    static int index = 0;

    //前序遍历，递归序列化
    //空节点用 # 表示
    //节点值用 number! 表示
    public static String Serialize(TreeNode root){
        if(root==null)
            return "#!";
        else
            return root.val + "!" + Serialize(root.left) + Serialize(root.right);
    }

    public static TreeNode Deserialize(String str){
        return DeserializeCore(str.split("!"),0);
    }

    public static TreeNode DeserializeCore(String[] str,int strt){
        if(index>=str.length)
            return null;
        if(!str[index].equals("#")){
            TreeNode root = new TreeNode(Integer.parseInt(str[index]));
            root.left = DeserializeCore(str,++index);
            root.right = DeserializeCore(str,++index);
            return root;
        }else{
            return null;
        }
    }

    public static void main(String[] args){
        //            8
        //        6      10
        //       5 7    9  11
        TreeNode<Integer> node6 = new TreeNode<>(6,5,7);
        TreeNode<Integer> node10 = new TreeNode<>(10,9,11);
        TreeNode<Integer> root = new TreeNode<>(8,node6,node10);
        String str = Serialize(root);
        System.out.println(str); //8!6!5!##7!##10!9!##11!##
        TreeNode<Integer> newRoot = Deserialize(str);
        TreeNode.PrintTree2(newRoot);
    }
}
