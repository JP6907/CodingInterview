package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

/**
 * @author shangqiu
 * @createTime 2020/8/3
 **/
public class Q110_isBalanced {

    public boolean isBalanced(TreeNode root) {
        return isBalancedCore(root).isBalanced;
    }

    public class Result{
        public boolean isBalanced;
        public int height;

        public Result(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public Result isBalancedCore(TreeNode root) {
        if(root == null){
            return new Result(true, 0);
        }
        if(root.left == null && root.right == null){
            return new Result(true, 1);
        }
        Result leftResult = isBalancedCore(root.left);
        Result rightResult = isBalancedCore(root.right);
        if(!leftResult.isBalanced || !rightResult.isBalanced
            || Math.abs(leftResult.height - rightResult.height) > 1){
            return new Result(false, -1);
        }
        return new Result(true, Math.max(leftResult.height, rightResult.height)+1);

    }
}
