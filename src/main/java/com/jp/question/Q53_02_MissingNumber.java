package com.jp.question;

// 面试题53（二）：0到n-1中缺失的数字
// 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字
// 都在范围0到n-1之内。在范围0到n-1的n个数字中有且只有一个数字不在该数组
// 中，请找出这个数字。
public class Q53_02_MissingNumber {

    // 0 1 2 3 4 5 6 7 8  n-1=8 n=9
    // n/2 = 4 a[4]=4
    // 0 2 3 4 5 6 7 8
    // a[4]=5 > 4  缺失的数字在前半断      不等
    // a[5]=6 > 5
    // 0 1 2 3 4 5 7 8
    // a[4]=4 = 4 缺失的数字在后半断       相等
    // 0 1 2 3 5 6 7 8
    // a[4]=5 > 4 && a[3]==3 正是缺失的数字          不等

    static int GetMissingNumber(int[] data){
        if(data.length==0)
            return -1;
        if(data.length==1&&data[0]!=0)
            return 0;
        int left = 0;
        int right = data.length-1;
        while(left<=right){
            int middle = (left+right)>>1;
            if(data[middle]!=middle){
                if(middle==0||data[middle-1]==middle-1)
                    return middle;
                else
                    right = middle-1;
            }else
                left = middle+1;
        }
        if(left==data.length)
            return left;
        return -1;
    }

    public static void main(String[] args){
        System.out.println(GetMissingNumber(new int[]{0,1,2,4,5,6,7,8,9}));
        System.out.println(GetMissingNumber(new int[]{0,1,2,3,5,6,7,8}));
        System.out.println(GetMissingNumber(new int[]{1,2,3,4,5,6}));
        System.out.println(GetMissingNumber(new int[]{0,1,2,3,4}));
    }
}
