package com.jp.LeetCode.question;

//Two elements of a binary search tree (BST) are swapped by mistake.
//Recover the tree without changing its structure.
//Example 1:
//
//Input: [1,3,null,null,2]
//
//   1
//  /
// 3
//  \
//   2
//
//Output: [3,1,null,null,2]
//
//   3
//  /
// 1
//  \
//   2
//Example 2:
//
//Input: [3,1,4,null,null,2]
//
//  3
// / \
//1   4
//   /
//  2
//
//Output: [2,1,4,null,null,3]
//
//  2
// / \
//1   4
//   /
//  3
//Follow up:
//
//A solution using O(n) space is pretty straight forward.
//Could you devise a constant space solution?

import com.jp.LeetCode.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//方法1：中序遍历树，并将所有节点存到一个一维向量中，把所有节点值存到另一个一维向量中，
// 然后对存节点值的一维向量排序，在将排好的数组按顺序赋给节点。
//1 2 3 4 5 6 7 8 9
//1 2 8 4 5 6 7 3 9
//中序遍历，储存出现的逆序对
//如果是相邻两个节点交换，则只有一个逆序对，否则有两对逆序对
public class Q99_RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        List<TreeNode> res = new ArrayList<TreeNode>();
        while (!stack.isEmpty()||p!=null){
            while (p!=null){
                stack.push(p);
                p = p.left;
            }
            if(!stack.isEmpty()){
                p = stack.pop();
                if(pre!=null&&pre.val>p.val){
                    res.add(pre);
                    res.add(p);
                }
                pre = p;
                p = p.right;
            }
        }
        TreeNode node1,node2;
        if(res.size()==2){
            node1 = res.get(0);
            node2 = res.get(1);
        }else{
            node1 = res.get(0);
            node2 = res.get(3);
        }
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;

    }
}
