package com.jp.CodingInterview.questions;

import com.jp.CodingInterview.datastruct.TreeNode;

public class Q26_SubstructureInTree2 {


        public static boolean HasSubtree(TreeNode<Integer> root1,TreeNode<Integer> root2){
            boolean result = false;
            if(root1!=null&&root2!=null){
                result = DoesHasSubTree(root1,root2);
                if(!result)
                    result = DoesHasSubTree(root1.lchild,root2);
                if(!result)
                    result = DoesHasSubTree(root1.rchild,root2);
            }
            return result;
        }

        public static boolean DoesHasSubTree(TreeNode<Integer> tree1, TreeNode<Integer> tree2){
            if(tree2==null)
                return true;
            if(tree1==null)
                return false;
            if(tree1.key!=tree2.key)
                return false;
            return DoesHasSubTree(tree1.lchild,tree2.lchild)&&DoesHasSubTree(tree1.rchild,tree2.rchild);
        }

}
