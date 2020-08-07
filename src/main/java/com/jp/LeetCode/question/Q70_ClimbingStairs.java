package com.jp.LeetCode.question;

//You are climbing a stair case. It takes n steps to reach to the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//Note: Given n will be a positive integer.
//
//Example 1:
//
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//Example 2:
//
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step

//动态规划
//f(n)=f(n-1)+f(n-2)
public class Q70_ClimbingStairs {

    public static int climbStairs(int n) {
        if(n<=2)
            return n;
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        for(int i=3;i<=n;i++)
            f[i] = f[i-1]+f[i-2];
        return f[n];
    }

    public static void test(int n,int expected){
        System.out.println(climbStairs(n)==expected);
        System.out.println(climbStairs2(n)==expected);
        System.out.println(climbStairs3(n)==expected);
        System.out.println("---");
    }

    public static void main(String[] args) {
        test(2,2);
        test(3,3);
    }

    public static int climbStairs2(int n) {
        if(n <= 2){
            return n;
        }
        return climbStairs2(n-1) + climbStairs2(n-2);
    }

    public static int climbStairs3(int n) {
        if(n <= 2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
