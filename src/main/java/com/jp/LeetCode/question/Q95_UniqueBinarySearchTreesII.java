package com.jp.LeetCode.question;

//Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
//
//Example:
//
//Input: 3
//Output:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//Explanation:
//The above output corresponds to the 5 unique BST's shown below:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3

import com.jp.LeetCode.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q95_UniqueBinarySearchTreesII {

    public static List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<TreeNode>();
        else
            return generateTreeCore(1,n);
    }

    public static List<TreeNode> generateTreeCore(int left,int right){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if(left>right){
            result.add(null);
            return result;
        }
        if(left==right) {
            result.add(new TreeNode(left));
            return result;
        }
        for(int root=left;root<=right;root++){
            TreeNode node = new TreeNode(root);
            List<TreeNode> leftResult = generateTreeCore(left,root-1);
            List<TreeNode> rightResult = generateTreeCore(root+1,right);
            for(TreeNode leftNode : leftResult){
                for(TreeNode rightNode : rightResult){
                    TreeNode now = new TreeNode(root);
                    now.left = leftNode;
                    now.right = rightNode;
                    result.add(now);
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {
        generateTrees(3);
    }
}
