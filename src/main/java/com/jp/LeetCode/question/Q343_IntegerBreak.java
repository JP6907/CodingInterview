package com.jp.LeetCode.question;

//Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
//
//Example 1:
//
//Input: 2
//Output: 1
//Explanation: 2 = 1 + 1, 1 × 1 = 1.
//Example 2:
//
//Input: 10
//Output: 36
//Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

//f(n)表示为分割为至少两个整数后的乘机最大值
//f(n)=Max(f(k)*f(n-k), k*f(n-k), f(k)*(n-k) , k*n-k) k= 1....n-1
//当 n>=4 f(n)>=n ,不需要再比较 k*f(n-k), f(k)*(n-k) ，只需要比较 f(k)*f(n-k) 和k*n-k
public class Q343_IntegerBreak {

    public static int integerBreak(int n) {
        if(n<=3)
            return n-1;
        if(n==4)
            return 4;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for(int i=5;i<=n;i++){
            for(int k=1;k<=i/2;k++){
                   dp[i] = Math.max(dp[i],Math.max(dp[k]*dp[i-k],k*(i-k)));
            }
        }
        return dp[n];
    }

    public static void test(int n,int expected){
        System.out.println(integerBreak(n)==expected);
    }

    public static void main(String[] args) {
        test(2,1);
        test(10,36);
        test(8,18);
    }
}
