package com.jp.CodingInterview.questions;

// 面试题26：树的子结构
// 题目：输入两棵二叉树A和B，判断B是不是A的子结构。

import com.jp.CodingInterview.datastruct.TreeNode;

//递归
public class Q26_SubstructureInTree {

    //浮点数比较不能直接用==，存在一定误差
    static boolean equal(Double num1,Double num2){
        if(((num1-num2)>-0.0000001d)&&((num1-num2)<0.0000001d))
            return true;
        else
            return false;
    }

    //判断pRoot2是不是pRoo1的子树
    static boolean doesTree1HaveTree2(TreeNode<Double> pRoot1,TreeNode<Double> pRoot2){
        if(pRoot2==null)
            return true;
        if(pRoot1==null)
            return true;
        if(!equal(pRoot1.key,pRoot2.key))
            return false;
        //递归
        return doesTree1HaveTree2(pRoot1.lchild,pRoot2.lchild) && doesTree1HaveTree2(pRoot1.rchild,pRoot2.rchild);
    }

    static boolean hasSubtree(TreeNode<Double> pRoot1,TreeNode<Double> pRoot2){
        //递归遍历pRoot1
        boolean result = false;
        if(pRoot1!=null){
            result = doesTree1HaveTree2(pRoot1,pRoot2);
            if(!result)
                result = doesTree1HaveTree2(pRoot1.lchild,pRoot2);
            if(!result)
                result = doesTree1HaveTree2(pRoot1.rchild,pRoot2);
        }
        return result;
    }

    public static void main(String[] args){
        //    8       8
        //  8  7     9 2
        //9  2
        //  4  7
        TreeNode<Double> pRoot2 = new TreeNode<Double>(8d,9d,2d);
        TreeNode<Double> node247 = new TreeNode<Double>(2d,4d,7d);
        TreeNode<Double> node887 = new TreeNode<Double>(8d,8d,7d);
        node887.lchild.setLchild(new TreeNode(9d));
        node887.lchild.setRchild(node247);
        TreeNode<Double> pRoot1 = node887;
        System.out.println(doesTree1HaveTree2(node887.lchild,pRoot2));
        System.out.println(hasSubtree(pRoot1,pRoot2));
    }
}
