package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;
import org.omg.CORBA.MARSHAL;

import java.util.*;

//Given the root of a tree, you are asked to find the most frequent subtree sum.
// The subtree sum of a node is defined as the sum of all the node values
// formed by the subtree rooted at that node (including the node itself).
// So what is the most frequent subtree sum value? If there is a tie,
// return all the values with the highest frequency in any order.
//
//Examples 1
//Input:
//
//  5
// /  \
//2   -3
//return [2, -3, 4], since all the values happen only once, return all of them in any order.
//Examples 2
//Input:
//
//  5
// /  \
//2   -5
//return [2], since 2 happens twice, however -5 only occur once.

//Subtree sum:STSum
//思路：Map记录每个节点的 STSum.递归求STSum
//后续遍历
public class Q508_MostFrequentSubtreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        if(root!=null) {
            postOrderTraverse(root);
            List<Integer> result = new ArrayList<>();
            for(int key : map.keySet()){
                if(map.get(key).equals(maxCount)){
                    result.add(key);
                }
            }
            int[] array = result.stream().mapToInt(Integer::valueOf).toArray();
            return array;
        }else {
            return new int[0];
        }
    }

    //每个sum出现的次数
    Map<Integer,Integer> map = new HashMap<>();
    int maxCount = 0;
    public int postOrderTraverse(TreeNode root){
        if(root!=null) {
            int left = postOrderTraverse(root.left);
            int right = postOrderTraverse(root.right);
            int sum = left+right+root.val;
            map.put(sum,map.getOrDefault(sum,0)+1);
            maxCount = Math.max(maxCount,map.get(sum));
            return sum;
        }else {
            return 0;
        }
    }

    public void test(){
//        TreeNode root = new TreeNode(5,2,-5);
//        int[] result = findFrequentTreeSum(root);
//        System.out.println(Arrays.toString(result));

        TreeNode root2 = new TreeNode(5,2,-3);
        int[] result2 = findFrequentTreeSum(root2);
        System.out.println(Arrays.toString(result2));
    }

    public static void main(String[] args) {
        new Q508_MostFrequentSubtreeSum().test();
    }
}
