package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shangqiu
 * @createTime 2020/7/21
 **/
public class Q95_GenerateTrees {

    public static List<TreeNode> generateTrees(int n) {
        if(n <= 0){
            return new ArrayList<>();
        }
        return generateTreesCore(1, n);
    }

    public static List<TreeNode> generateTreesCore(int left, int right){
        List<TreeNode> result = new ArrayList<>();
        if(left > right){
            result.add(null);
        }
        if(left == right){
            result.add(new TreeNode(left));
        } else {
            for(int root=left;root<=right;root++){
                List<TreeNode> leftTrees = generateTreesCore(left, root-1);
                List<TreeNode> rightTrees = generateTreesCore(root+1, right);

                for(TreeNode leftTree : leftTrees){
                    for (TreeNode rightTree : rightTrees){
                        TreeNode curr = new TreeNode(root);
                        curr.left = leftTree;
                        curr.right = rightTree;
                        result.add(curr);
                    }
                }
            }
        }
        return result;
    }


}
