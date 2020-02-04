package com.jp.CodingInterview;

// 面试题64：求1+2+…+n
// 题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case
// 等关键字及条件判断语句（A?B:C）。

public class Q64_Accumulate {

    //递归
    //利用逻辑与的短路特性实现递归终止
    //当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0
    //当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)
    static int Sum_Solution1(int n){
        int res = n;
        boolean flag = (n>0)&&((res+=Sum_Solution1(n-1))>0);
        return res;
    }

    //库函数
    static int Sum_Solution2(int n){
        //n*(n+1)/2 = n^2+n  /2
        int sum = (int)(Math.pow(n,2)+n);
        return sum>>1;
    }


    public static void main(String[] args){
        System.out.println(Sum_Solution1(3));
        System.out.println(Sum_Solution1(4));
        System.out.println(Sum_Solution1(5));

        System.out.println(Sum_Solution2(3));
        System.out.println(Sum_Solution2(4));
        System.out.println(Sum_Solution2(5));
    }
}
