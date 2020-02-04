package com.jp.CodingInterview;


import com.jp.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 面试题34：二叉树中和为某一值的路径
// 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
// 有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
public class Q34_PathInTree {

    static void FindPath(TreeNode<Integer> root,int expectedNum){
        FindPathRecursively(root,new ArrayList<Integer>(),0,expectedNum);
    }

    static void FindPathRecursively(TreeNode<Integer> root, List<Integer> path,int currentSum,int expectedNum){
        if(root!=null){
            if(root.key+currentSum<expectedNum){
                path.add(root.key);
                if(root.lchild!=null){
                    //不能直接传入path
                    //参数一个引用，如果传入path，会导致所有访问过的节点都保存在path中
                    FindPathRecursively(root.lchild,new ArrayList<Integer>(path),currentSum+root.key,expectedNum);
                }
                if(root.rchild!=null){
                    FindPathRecursively(root.rchild,new ArrayList<Integer>(path),currentSum+root.key,expectedNum);
                }
            }else if(root.lchild==null&&root.rchild==null&&(root.key+currentSum==expectedNum)){
                //到底叶子节点就计算总和
                path.add(root.key);
                PrintPath(path);
            }
        }
    }

    static void PrintPath(List<Integer> path){
        System.out.println("Find path : " + Arrays.toString(path.toArray()));
    }

    public static void main(String[] args){
        //     10
        //    5  12
        //   4 7
        TreeNode<Integer> node547 = new TreeNode<Integer>(5,4,7);
        TreeNode<Integer> root = new TreeNode<Integer>(10);
        root.setLchild(node547);
        root.setRchild(new TreeNode(12));

        FindPath(root,22);
    }
}
