package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Q103_BinaryTreeZigzagLevelOrderTraversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null)
            return result;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        List<Integer> currList = new ArrayList<Integer>();
        TreeNode p;
        int currLevel = 0;
        stack1.push(root);
        while (!stack1.empty()||!stack2.empty()){
            p = stack1.pop();
            currList.add(p.val);
            if(currLevel%2==0) {
                if (p.left != null) {
                    stack2.push(p.left);
                }
                if (p.right != null) {
                    stack2.push(p.right);
                }
            }else {
                if (p.right != null) {
                    stack2.push(p.right);
                }
                if (p.left != null) {
                    stack2.push(p.left);
                }
            }
            if(stack1.empty()){
                result.add(new ArrayList<Integer>(currList));
                currList.clear();
                Stack<TreeNode> temp = stack1;
                stack1 = stack2;
                stack2 = temp;
                currLevel++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //    3
        //   / \
        //  9  20
        //    /  \
        //   15   7
        TreeNode node20 = new TreeNode(20,15,7);
        TreeNode root = new TreeNode(3,new TreeNode(9),node20);
        List<List<Integer>> result = zigzagLevelOrder(root);
        for(List<Integer> r : result){
            System.out.println(Arrays.toString(r.toArray()));
        }
        System.out.println("====");
        result = zigzagLevelOrder(null);
        for(List<Integer> r : result){
            System.out.println(Arrays.toString(r.toArray()));
        }
    }
}
