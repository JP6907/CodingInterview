package com.jp.LeetCode.ByteDance;

import com.jp.LeetCode.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author shangqiu
 * @createTime 2020/7/24
 **/
public class Q_lowestCommonAncestor {

    //保存两个节点的路径，问题转化为求两个链表的第一个公共节点
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        getPath(root, p, pPath);
        getPath(root, q, qPath);
        if(pPath.size() == 0 || qPath.size() == 0){
            return null;
        }
        int lenP = pPath.size();
        int lenQ = qPath.size();
        int indexP = lenP-1, indexQ = lenQ-1;
        while (indexP > indexQ){
            indexP--;
        }
        while (indexQ > indexP){
            indexQ--;
        }
        while (indexP >= 0  && indexQ >= 0 && pPath.get(indexP) != qPath.get(indexQ)){
            indexP--;
            indexQ--;
        }
        if(indexP >= 0){
            return pPath.get(indexP);
        } else {
            return null;
        }
    }

    public static boolean getPath(TreeNode root, TreeNode target, List<TreeNode> result){
        if(root == target){
            result.add(root);
            return true;
        } else {
            if(root == null){
                return false;
            }
            result.add(root);
            boolean left = getPath(root.left, target, result);
            if(left) {
                return true;
            }
            boolean right = getPath(root.right, target, result);
            if(right){
                return true;
            }
            result.remove(result.size()-1);
            return false;
        }
    }

//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        Stack<TreeNode> stack = new Stack<>();
//        List<>
//    }

}
