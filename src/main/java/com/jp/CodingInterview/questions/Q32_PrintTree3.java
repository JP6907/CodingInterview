package com.jp.CodingInterview.questions;

// 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
// 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

import com.jp.CodingInterview.datastruct.TreeNode;

import java.util.*;

//层次打印树
//之字形打印
public class Q32_PrintTree3 {


    //从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
    public static ArrayList<ArrayList<Integer>> Print0(TreeNode<Integer> pRoot){
        if(pRoot==null)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int levelCount = 0; //下一层节点计数
        int nodeLeft = 1; //当前层剩余节点
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            TreeNode<Integer> node = queue.poll();
            list.add(node.val);
            if(node.left!=null){
                levelCount++;
                queue.offer(node.left);
            }
            if(node.right!=null){
                levelCount++;
                queue.offer(node.right);
            }
            if(--nodeLeft==0){
                result.add((ArrayList<Integer>)list.clone());
                list.clear();
                nodeLeft = levelCount;
                levelCount = 0;
            }
        }
        return result;
    }

    //层次遍历
    //每一行的元素使用stack储存
    public static ArrayList<ArrayList<Integer>> Print(TreeNode<Integer> pRoot){
        if(pRoot==null)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        List<Stack<TreeNode<Integer>>> stacks = new ArrayList<>();
        stacks.add(new Stack<TreeNode<Integer>>());
        stacks.add(new Stack<TreeNode<Integer>>());
        int isOdd = 0;  //当前level 奇数层为1，偶数层为0
        int levelCount = 0; //下一层节点计数
        int nodeLeft = 1; //当前层剩余节点
        stacks.get(0).push(pRoot);
        while (!stacks.get(isOdd).isEmpty()){
            TreeNode<Integer> node = stacks.get(isOdd).pop();
            list.add(node.val);
            if(isOdd==0) {
                if (node.left != null) {
                    levelCount++;
                    stacks.get(1 - isOdd).push(node.left);
                }
                if (node.right != null) {
                    levelCount++;
                    stacks.get(1 - isOdd).push(node.right);
                }
            }else{
                if (node.right != null) {
                    levelCount++;
                    stacks.get(1 - isOdd).push(node.right);
                }
                if (node.left != null) {
                    levelCount++;
                    stacks.get(1 - isOdd).push(node.left);
                }
            }
            if(--nodeLeft==0){
                result.add((ArrayList<Integer>)list.clone());
                list.clear();
                nodeLeft = levelCount;
                levelCount = 0;
                isOdd = 1-isOdd;
            }
        }
        return result;
    }

    public static void PrintTree(TreeNode<Integer> pRoot){
        ArrayList<ArrayList<Integer>> result = Print(pRoot);
        for(ArrayList<Integer> list : result)
            System.out.println(list.toString());
    }

    public static void main(String[] args){
        //            8
        //        6      10
        //       5 7    9  11
        TreeNode<Integer> node6 = new TreeNode<>(6,5,7);
        TreeNode<Integer> node10 = new TreeNode<>(10,9,11);
        TreeNode<Integer> root = new TreeNode<>(8,node6,node10);
        PrintTree(root);
    }
}
