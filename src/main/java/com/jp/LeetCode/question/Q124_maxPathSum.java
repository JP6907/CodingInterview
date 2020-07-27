package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

/**
 * @author zjp
 * @createTime 2020/7/27 22:23
 **/
public class Q124_maxPathSum {

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    static int maxSum = Integer.MIN_VALUE;
    //以root为根节点的最大路径
    public static int maxGain(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(maxGain(root.left), 0);
        int right = Math.max(maxGain(root.right), 0);

        int currPathSum = root.val + left + right;
        maxSum = Math.max(maxSum, currPathSum);

        return root.val + Math.max(left, right);

    }

    public static void test(TreeNode root, int expected){
        System.out.println(maxPathSum(root) == expected);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, 2, 3);
        test(root, 6);
        root = new TreeNode(-10, new TreeNode(9), new TreeNode(20, 15, 7));
        test(root, 42);
        root = new TreeNode(-3);
        test(root, -3);
    }
}
