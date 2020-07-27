package com.jp.LeetCode.question;

//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//For example:
//Given binary tree [3,9,20,null,null,15,7],
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its level order traversal as:
//[
//  [3],
//  [9,20],
//  [15,7]
//]

import com.jp.LeetCode.datastruct.TreeNode;

import java.util.*;

public class Q102_BinaryTreeLevelOrderTraversal {

    //层次遍历
    //使用队列
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null)
            return result;
        int nextLevelCount = 0;  //下一层计数
        int currLevelLeft = 1; //当前层剩余数量
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<Integer> list = new ArrayList<Integer>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left!=null) {
                queue.offer(node.left);
                nextLevelCount++;
            }
            if(node.right!=null) {
                queue.offer(node.right);
                nextLevelCount++;
            }
            if(--currLevelLeft==0){
                result.add(new ArrayList<Integer>(list));
                list.clear();
                currLevelLeft = nextLevelCount;
                nextLevelCount = 0;
            }
        }
        return result;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currCount = 1;
        int nextCount = 0;
        TreeNode p;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            p = queue.poll();
            list.add(p.val);
            if(p.left != null){
                queue.add(p.left);
                nextCount++;
            }
            if(p.right != null){
                queue.add(p.right);
                nextCount++;
            }
            if(--currCount == 0){
                currCount = nextCount;
                nextCount = 0;
                result.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return result;
    }

    public static void Test(TreeNode root){
        List<List<Integer>> result = levelOrder(root);
        for(List<Integer> list : result){
            System.out.println(Arrays.toString(list.toArray()));
        }
        System.out.println("---");
        result = levelOrder2(root);
        for(List<Integer> list : result){
            System.out.println(Arrays.toString(list.toArray()));
        }
        System.out.println("======");
    }

    public static void main(String[] args) {
        //    3
        //   / \
        //  9  20
        //    /  \
        //   15   7
        TreeNode node20 = new TreeNode(20,15,7);
        TreeNode node3 = new TreeNode(3,new TreeNode(9),node20);
        Test(node3);
    }
}
