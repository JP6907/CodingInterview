package com.jp.LeetCode.question;

//Given an unsorted array of integers, find the length of longest increasing subsequence.
//
//Example:
//
//Input: [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
//Note:
//
//There may be more than one LIS combination, it is only necessary for you to return the length.
//Your algorithm should run in O(n2) complexity.
//Follow up: Could you improve it to O(n log n) time complexity?

import java.lang.reflect.Array;
import java.util.Arrays;

//可以非连续
//动态规划
//f[i]=max(f[j])+1 (1<=j<iandxj<xi)
public class Q300_LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n<2)
            return n;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for(int i=1;i<n;i++){
            int maxPre = 0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]&&dp[j]>maxPre)
                    maxPre = dp[j];
            }
            dp[i] = maxPre+1;
            max = Math.max(max,dp[i]);
        }
        return max;
    }


    public static void test(int[] nums,int expected){
        System.out.println(lengthOfLIS(nums)==expected);
        System.out.println(lengthOfLIS2(nums)==expected);
    }

    public static void main(String[] args) {
        test(new int[]{10,9,2,5,3,7,101,18},4);
    }


    public static int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len];
        int result = 1;
        Arrays.fill(dp, 1);
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
