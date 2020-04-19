package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Q173_BinarySearchTreeIterator {

    class BSTIterator {

        TreeNode curr;
        Iterator<TreeNode> iterator;


        public BSTIterator(TreeNode root) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            getIterator(root,list);
            iterator = list.iterator();
        }

        //中序遍历
        private void getIterator(TreeNode root,List<TreeNode> list){
            if(root!=null){
                getIterator(root.left,list);
                list.add(root);
                getIterator(root.right,list);
            }
        }

        /** @return the next smallest number */
        public int next() {
            return iterator.next().val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }

    //模仿中序遍历非递归过程
    class BSTIterator2 {

        Stack<TreeNode> stack;
        TreeNode p;

        public BSTIterator2(TreeNode root) {
            stack = new Stack<TreeNode>();
            p = root;
            while (p!=null){
                stack.push(p);
                p = p.left;
            }
        }


        /** @return the next smallest number */
        public int next() {
            p = stack.pop();
            int val = p.val;
            p = p.right;
            while (p!=null){
                stack.push(p);
                p = p.left;
            }
            return val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.empty();
        }
    }
}
