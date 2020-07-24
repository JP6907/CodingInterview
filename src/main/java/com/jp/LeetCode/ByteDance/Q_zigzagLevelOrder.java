package com.jp.LeetCode.ByteDance;

import com.jp.LeetCode.datastruct.TreeNode;

import java.util.*;

/**
 * @author shangqiu
 * @createTime 2020/7/24
 **/
public class Q_zigzagLevelOrder {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        int level = 1;
        int currCount = 1;
        int nextCount = 0;
        stack1.add(root);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.empty()){
            if(level % 2 != 0) {
                TreeNode node = stack1.pop();
                list.add(node.val);
                if (node.left != null) {
                    stack2.add(node.left);
                    nextCount++;
                }
                if (node.right != null) {
                    stack2.add(node.right);
                    nextCount++;
                }
            } else {
                TreeNode node = stack2.pop();
                list.add(node.val);
                if (node.right != null) {
                    stack1.add(node.right);
                    nextCount++;
                }
                if (node.left != null) {
                    stack1.add(node.left);
                    nextCount++;
                }
            }
            if(--currCount == 0){
                result.add(new ArrayList<>(list));
                list.clear();
                currCount = nextCount;
                nextCount = 0;
                level++;
            }
        }
        return result;
    }

    public static void test(TreeNode root){
        List<List<Integer>> result = zigzagLevelOrder(root);
        for(List<Integer> l : result){
            System.out.println(Arrays.toString(l.toArray()));
        }
        System.out.println("===");
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20, 15, 7);
        TreeNode root = new TreeNode(3, node1, node2);
        test(root);
    }

}
