package com.jp.CodingInterview.questions;


// 面试题42：连续子数组的最大和
// 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整
// 数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
public class Q42_GreatestSumOfSubarrays {

    //动态规划
    // f(i) 表示以第i个数字结尾的子数组的最大和
    // i=0 或者 f(i-1)<=0 : f(i) = data[i]
    // f(i-1)>0 : f(i) = f(i-1) + data[i]
    static int FindGreastSumOfSubArray(Integer[] data){
        Integer[] f = new Integer[data.length];
        for(int i=0;i<data.length;i++){
            if(i==0||f[i-1]<=0)
                f[i] = data[i];
            else
                f[i] = f[i-1] + data[i];
        }
        return f[data.length-1];
    }

    public static void main(String[] args){
        Integer[] data = {1,-2,3,10,-4,7,2,-5};
        int result = FindGreastSumOfSubArray(data);
        assert result == 18;
    }
}
