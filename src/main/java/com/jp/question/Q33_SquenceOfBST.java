package com.jp.question;

import java.util.Arrays;
import java.util.List;

// 面试题33：二叉搜索树的后序遍历序列
// 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
public class Q33_SquenceOfBST {

    static boolean VerifySequenceOfBST(List<Integer> sequence,int left,int right){
        if(sequence==null||sequence.size()<=0||right>=sequence.size()||left<0||left>right)
            return false;
        if(left==right)
            return true;
        //root
        int root = sequence.get(right);
        //寻找比root小的左半部分
        int middle = left;
        for(;middle<=right&&sequence.get(middle)<root;middle++);
        //剩下的右半部分应该都比root大
        for(int i=middle;i<=right;i++){
            if(sequence.get(i)<root)
                return false;
        }
        //分别判断左子树和右子树分别是不是二叉搜索树
        boolean leftResult = true;
        boolean rightResult = true;
        if(middle>left)
            leftResult = VerifySequenceOfBST(sequence,left,middle-1);
        if(middle<right)
            rightResult = VerifySequenceOfBST(sequence,middle,right-1);
        return leftResult&&rightResult;
    }

    public static void main(String[] args){
        List<Integer> sequence = Arrays.asList(5,7,6,9,11,10,8);
        System.out.println(VerifySequenceOfBST(sequence,0,sequence.size()-1));
        sequence = Arrays.asList(7,4,6,5);
        System.out.println(VerifySequenceOfBST(sequence,0,sequence.size()-1));
    }
}
