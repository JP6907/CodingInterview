package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

//Given a binary tree, find the leftmost value in the last row of the tree.
//
//Example 1:
//Input:
//
//    2
//   / \
//  1   3
//
//Output:
//1
//Example 2:
//Input:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
//Output:
//7
//Note: You may assume the tree (i.e., the given root node) is not NULL.

//层次遍历，最后一层的第一个节点
//深度优先遍历，保证左先于右遍历，记录每一层出现的第一个节点，取最大层
//改进：
//DFS，左先于右
//遍历过程记录最大level
//更新最大level的时候记录当前节点的值
//每一个level第一次出现的节点必定是最左的节点
public class Q513_FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return target;
    }

    int maxLevel = -1;
    int target = 0;
//    public void dfs(TreeNode root,int currLevel){
//        if(root!=null){
//            if(currLevel>maxLevel){
//                target = root.val;
//                maxLevel = currLevel;
//            }
//            currLevel++;
//            dfs(root.left,currLevel);
//            dfs(root.right,currLevel);
//        }
//    }

    public void dfs(TreeNode root, int currLevel){
        if(root != null){
            if(currLevel > maxLevel){
                target = root.val;
                maxLevel = currLevel;
            }
            currLevel++;
            dfs(root.left, currLevel);
            dfs(root.right, currLevel);
        }
    }

}
