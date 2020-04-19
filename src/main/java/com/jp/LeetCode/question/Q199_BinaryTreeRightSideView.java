package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given a binary tree, imagine yourself standing on the right side of it,
// return the values of the nodes you can see ordered from top to bottom.
//
//Example:
//
//Input: [1,2,3,null,5,null,4]
//Output: [1, 3, 4]
//Explanation:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
public class Q199_BinaryTreeRightSideView {
    //层次遍历，取每一层的最后一个/广度优先遍历
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode p = root;
        queue.offer(p);
        int currCount = 1;
        int nextCount = 0;
        while (!queue.isEmpty()){
            p = queue.poll();
            if(p.left!=null){
                queue.offer(p.left);
                nextCount++;
            }
            if(p.right!=null){
                queue.offer(p.right);
                nextCount++;
            }
            if(--currCount==0){
                result.add(p.val);
                currCount = nextCount;
                nextCount = 0;
            }
        }
        return result;
    }
}
