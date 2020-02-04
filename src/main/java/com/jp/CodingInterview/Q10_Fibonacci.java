package com.jp.CodingInterview;

// 面试题10：斐波那契数列
// 题目：写一个函数，输入n，求斐波那契（Fibonacci）数列的第n项。
// 拓展：青蛙跳台阶问题实际上就是Fibonacci问题
public class Q10_Fibonacci {

    /**
     * 解法1：递归
     */
    public static long Fibonacci_1(int n){
        if(n<=0)
            return 0;
        else if(n==1)
            return 1;
        else
            return Fibonacci_1(n-1) + Fibonacci_1(n-2);
    }

    /**
     * 解法2：循环
     */
    public static long Fibonacci_2(int n){
        int[] result = {0,1};
        if(n<2)
            return result[n];

        long fibNMinusOne = 1; //n-1
        long fibNMinusTwo = 0; //n-2
        long fibN = 0;
        for(int i=2;i<=n;i++){
            fibN = fibNMinusOne + fibNMinusTwo;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }

    // 变态跳台阶
    // 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法

    public static void main(String[] args){
        System.out.println(Fibonacci_1(10));
        System.out.println(Fibonacci_2(10));
    }
}

