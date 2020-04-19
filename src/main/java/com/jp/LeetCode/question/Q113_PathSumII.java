package com.jp.LeetCode.question;


import com.jp.LeetCode.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q113_PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null)
            return result;
        pathSumCore(root,sum,new ArrayList<Integer>(),result);
        return result;

    }

    public void pathSumCore(TreeNode root,int sum,List<Integer> currPath,List<List<Integer>> result){
        if(root.left==null&&root.right==null){
            if(root.val==sum){
                currPath.add(root.val);
                result.add(new ArrayList<Integer>(currPath));
                currPath.remove(currPath.size()-1);
            }
        }else {
            sum -= root.val;
            currPath.add(root.val);
            if(root.left!=null){
                pathSumCore(root.left,sum,currPath,result);
            }
            if(root.right!=null){
                pathSumCore(root.right,sum,currPath,result);
            }
            currPath.remove(currPath.size()-1);
        }
    }
}
