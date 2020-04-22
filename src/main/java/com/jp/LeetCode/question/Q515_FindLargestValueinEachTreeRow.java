package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

//寻找每一层的最大值
//方法一：层次遍历
//方法二：DFS
public class Q515_FindLargestValueinEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root,result,0);
        return result;
    }

    public void dfs(TreeNode root,List<Integer> result,int level){
        if(root!=null){
            if(result.size()==level){
                result.add(root.val);
            }else {
                if(result.get(level)<root.val){
                    result.set(level,root.val);
                }
            }
            level++;
            dfs(root.left,result,level);
            dfs(root.right,result,level);
        }
    }
}
