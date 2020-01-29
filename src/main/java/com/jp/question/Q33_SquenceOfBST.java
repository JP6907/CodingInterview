package com.jp.question;


// 33: 二叉搜索树的后序遍历序列
// 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
public class Q33_SquenceOfBST {

    // 二叉搜索树
    // 有序 ， 左<根<右
    public static boolean VerifySquenceOfBST(int[] sequence){
        if(sequence.length==0)
            return false;
        return VerifySquenceOfBSTCore(sequence,0,sequence.length-1);
    }

    public static boolean VerifySquenceOfBSTCore(int[] sequence,int left,int right){
        if(left==right)
            return true;
        if(left>right)
            return false;
        //最后一个元素为根节点
        int root = sequence[right];
        //右子树的第一个节点
        int firstRightIndex = left;
        while (firstRightIndex<right&&sequence[firstRightIndex]<root)
            firstRightIndex++;
        for(int i=firstRightIndex;i<right;i++){
            if(sequence[i]<root)
                return false;
        }
        if(firstRightIndex==left){ //只有右子树
            return VerifySquenceOfBSTCore(sequence,firstRightIndex,right-1);
        }else if(firstRightIndex==right){ //只有左子树
            return VerifySquenceOfBSTCore(sequence,left,firstRightIndex-1);
        }else {
            return VerifySquenceOfBSTCore(sequence, left, firstRightIndex - 1) &&
                    VerifySquenceOfBSTCore(sequence, firstRightIndex, right);
        }
    }

    public static void Test(int[] sequence,boolean expected){
        System.out.println(VerifySquenceOfBST(sequence)==expected);
    }

    public static void main(String[] args){
        //            10
        //         /      \
        //        6        14
        //       /\        /\
        //      4  8     12  16
        Test(new int[]{4, 8, 6, 12, 16, 14, 10},true);

        //           5
        //          / \
        //         4   7
        //            /
        //           6
        Test(new int[]{4, 6, 7, 5},true);

        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        Test(new int[]{1, 2, 3, 4, 5},true);

        Test(new int[]{7, 4, 6, 5},false);
        Test(new int[]{4, 6, 12, 8, 16, 14, 10},false);
    }

}
