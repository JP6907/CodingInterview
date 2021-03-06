package com.jp.LeetCode.question;


import com.jp.LeetCode.datastruct.TreeNode;

//Given the sorted array: [-10,-3,0,5,9],
//
//One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
public class Q108_ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
            return null;
        return build(nums,0,nums.length-1);
    }

    public TreeNode build(int[] nums,int left,int right){
        if(left>right)
            return null;
        int mid = (left+right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = (left<mid?build(nums,left,mid-1):null);
        root.right = (mid<right?build(nums,mid+1,right):null);
        return root;
    }

    public TreeNode sortedArrayToBST2(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return null;
        }
        return sortedArrayToBSTCore2(nums, 0, len - 1);
    }

    public TreeNode sortedArrayToBSTCore2(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTCore2(nums, left, mid - 1);
        root.right = sortedArrayToBSTCore2(nums, mid + 1, right);
        return root;
    }






























}
