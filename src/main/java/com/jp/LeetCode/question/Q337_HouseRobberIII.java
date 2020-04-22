package com.jp.LeetCode.question;

//The thief has found himself a new place for his thievery again.
// There is only one entrance to this area, called the "root."
// Besides the root, each house has one and only one parent house.
// After a tour, the smart thief realized that "all houses in this place forms a binary tree".
// It will automatically contact the police if two directly-linked houses were broken into on the same night.
//
//Determine the maximum amount of money the thief can rob tonight without alerting the police.

import com.jp.LeetCode.datastruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q337_HouseRobberIII {

    //动态规划
    //对于每个节点
    //抢：则其子节点不能抢
    //不抢：抢其子节点
    Map<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);
        int robIt = root.val; //抢
        if(root.left!=null){
            robIt += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right!=null){
            robIt += rob(root.right.left) + rob(root.right.right);
        }
        int notRobIt = rob(root.left) + rob(root.right); //不抢
        int result = Math.max(robIt,notRobIt);
        map.put(root,result);
        return result;
    }
}
