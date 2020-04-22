package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

import java.util.*;

//二叉搜索树
//左<=根<=右
//找出出现次数最多的元素，可能有多个
//For example:
//Given BST [1,null,2,2],
//
//   1
//    \
//     2
//    /
//   2
//
//
//return [2].
//
//Note: If a tree has more than one mode, you can return them in any order.
//不使用额外空间，递归调用产生的栈空间不算

//https://leetcode.com/problems/find-mode-in-binary-search-tree/discuss/518672/C%2B%2B-real-O(1)-space-traversal-twice-%22fake-O(1)%22-extra-space-traversal-once
//方法1：遍历，Map计数，时间复杂度为O(n)
//方法2：利用中序遍历的特点，相同的元素会排列在一起，只需要维护当前的最大值，不需要维护所有值的计数值
//       遍历采用递归的方式，递归调用产生的栈空间不算
//       最坏情况下需要O(n)
//       fake O(1)
//方法3：和方法2类似
//       遍历两次，第一次找出出现最多的次数，第二次搜集出现最多次数的节点
public class Q501_FindModeinBinarySearchTree {

    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];
        inOrderTraverse(root);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            res[i] = result.get(i);
        return res;
    }

    public TreeNode pre = null;
    public int curCount = 0;
    public int maxCount = Integer.MIN_VALUE;
    public List<Integer> result = new ArrayList<>();

    public void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            if (pre == null) {
                curCount = 1;
                maxCount = curCount;
                result.add(root.val);
            } else {
                if (pre.val == root.val) {
                    curCount++;
                }else {
                    curCount = 1;
                }
                if(curCount>maxCount){
                    result.clear();
                    result.add(root.val);
                    maxCount = curCount;
                }else if(curCount==maxCount){
                    result.add(root.val);
                }
            }
            pre = root;
            inOrderTraverse(root.right);
        }
    }

    public void test(){
        TreeNode node2 = new TreeNode(2,new TreeNode(2),null);
        TreeNode root = new TreeNode(1,null,node2);
        int[] result = findMode(root);
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        new Q501_FindModeinBinarySearchTree().test();
    }

}