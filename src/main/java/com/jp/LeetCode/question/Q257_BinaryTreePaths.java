package com.jp.LeetCode.question;

//Given a binary tree, return all root-to-leaf paths.
//
//Note: A leaf is a node with no children.
//
//Example:
//
//Input:
//
//   1
// /   \
//2     3
// \
//  5
//
//Output: ["1->2->5", "1->3"]
//
//Explanation: All root-to-leaf paths are: 1->2->5, 1->3

import com.jp.LeetCode.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q257_BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root==null)
            return result;
        binaryTreePathCore(root,null,result);
        return result;
    }

    public void binaryTreePathCore(TreeNode currNode,String curPath,List<String> result){
        if(currNode==null)
            return;
        if(curPath==null)
            curPath = (currNode.val + "");
        else
            curPath += ("->" + currNode.val);
        if(currNode.left==null&&currNode.right==null){
            result.add(curPath);
        }else {
            binaryTreePathCore(currNode.left,curPath,result);
            binaryTreePathCore(currNode.right,curPath,result);
        }
    }
}
