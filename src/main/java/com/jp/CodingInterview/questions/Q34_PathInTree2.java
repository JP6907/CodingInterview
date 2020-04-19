package com.jp.CodingInterview.questions;

// 输入一颗二叉树的跟节点和一个整数，
// 打印出二叉树中结点值的和为输入整数的所有路径。
// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
// (注意: 在返回值的list中，数组长度大的数组靠前)

import com.jp.CodingInterview.datastruct.TreeNode;

import java.util.ArrayList;

public class Q34_PathInTree2 {

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode<Integer> root, int target){
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        FindPathCore(root,target,paths,new ArrayList<>(),0);
        return paths;
    }

    public static void FindPathCore(TreeNode<Integer> root,int target, ArrayList<ArrayList<Integer>> paths,
                                    ArrayList<Integer> currentPath,int currentSum){
        if(root!=null){
            //必须是叶子节点
            if(root.left==null&&root.right==null&&root.val+currentSum==target){
                currentPath.add(root.val);
                paths.add(new ArrayList<>(currentPath));
                currentPath.remove(currentPath.size()-1);
            }else if(root.val+currentSum<target){
                currentPath.add(root.val);
                currentSum+=root.val;
                if(root.left!=null){
                    FindPathCore(root.left,target,paths,currentPath,currentSum);
                }
                if(root.right!=null){
                    FindPathCore(root.right,target,paths,currentPath,currentSum);
                }
                currentPath.remove(currentPath.size()-1);
            }
        }
    }

    public static void main(String[] args){
        //     10
        //    5  12
        //   4 7
        TreeNode<Integer> node547 = new TreeNode<Integer>(5,4,7);
        TreeNode<Integer> root = new TreeNode<Integer>(10,node547,new TreeNode(12));
        ArrayList<ArrayList<Integer>> paths= FindPath(root,22);
        for(ArrayList<Integer> path : paths){
            System.out.println(path.toString());
        }

        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        // 有一条路径上面的结点和为15
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2,node1,null);
        TreeNode<Integer> node3 = new TreeNode<>(3,node2,null);
        TreeNode<Integer> node4 = new TreeNode<>(4,node3,null);
        TreeNode<Integer> node5 = new TreeNode<>(5,node4,null);
        paths= FindPath(node5,15);
        for(ArrayList<Integer> path : paths){
            System.out.println(path.toString());
        }
    }
}
