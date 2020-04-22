package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;
import org.omg.CORBA.MARSHAL;
import org.omg.PortableInterceptor.INACTIVE;

//Given a binary tree, you need to compute the length of the diameter of the tree.
// The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
// This path may or may not pass through the root.
//
//Example:
//Given a binary tree
//          1
//         / \
//        2   3
//       / \
//      4   5
//Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
//
//Note: The length of path between two nodes is represented by the number of edges between them.
public class Q543_DiameterofBinaryTree {

    //往左子节点遍历的最大深度+往右子节点遍历的最大深度
    //最大值不一定在根节点处
    //深度优先遍历

    public int diameterOfBinaryTree(TreeNode root) {
        if(root!=null){
            dfsDepth(root);
            return maxPath;
        }else {
            return 0;
        }
    }
    int maxPath = Integer.MIN_VALUE;
    public int dfsDepth(TreeNode root){
        if(root!=null){
            int left = root.left==null?0:(dfsDepth(root.left)+1);
            int right = root.right==null?0:(dfsDepth(root.right)+1);
            maxPath = Math.max(maxPath,left+right);
            if(left==0&&right==0)
                return 0;
            else
                return Math.max(left,right);
        }else {
            return 0;
        }
    }

    public void test(){
        //          1
        //         / \
        //        2   3
        //       / \
        //      4   5
        TreeNode node2 = new TreeNode(2,4,5);
        TreeNode root = new TreeNode(1,node2,new TreeNode(3));
        diameterOfBinaryTree(root);
        //Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
        System.out.println(maxPath);
    }

    public static void main(String[] args) {
        new Q543_DiameterofBinaryTree().test();
    }
}
