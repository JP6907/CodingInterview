package com.jp.questions;

import java.util.Arrays;

//字符串问题
public class QString {

    public static void main(String[] args) {
        //最长递增子序列
        testLISequence(new int[]{4,2,3,1,5},3);
        //最长递增子串
        testLISubstring(new int[]{10,9,2,5,3,7,101,18},3); //3, 7, 101
        //最大子序列和
        testMSS(new int[]{-2,1,-3,4,-1,2,1,-5,4},6);
        //最长回文子序列(
        testMPSequenceL(new int[]{1,2,2,4,5,6,2,3,5,4},5); //45254
        ////最长回文子串
        testMPSubstringL(new int[]{4,5,2,5,4,3,2,5,2},5); //45254
        //最长公共子序列
        testLCSequence("helloworld","hlelodo",5); //hlloo
        //最长公共子串
        testLCSubstring("helloworld","asdlowows",4); //lowo
    }

    //最长递增子序列
    //dp[i] 表示以i为结尾的最长递增子序列长度
    //dp[i] = max(dp[k]) +1，k<i且a[k]<a[i]
    public static int longestIncreasingSequence(int[] nums){
         int n = nums.length;
         int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        int max=1;
        for(int i=1;i<n;i++){
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }

    public static void testLISequence(int[] nums,int expected){
        System.out.println(longestIncreasingSequence(nums)==expected);
    }

    //最长递增子串
    //dp[i]表示以i为结尾的最长递增字串的长度
    //dp[i] = dp[i-1]+1, a[i]>a[i-1]
    //dp[i] = 1,a[i]<a[i-1]
    public static int longestIncreasingSubstring(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1])
                dp[i] = dp[i-1] + 1;
        }
        int max = 1;
        for(int i=0;i<n;i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void testLISubstring(int[] nums,int expected){
        System.out.println(longestIncreasingSubstring(nums)==expected);
    }

    //最大子序列和(连续)
    //dp[i]表示已i为结尾的最大子序列
    //dp[i] = dp[i-1] + a[i]  ,dp[i-1]>0
    //dp[i] = a[i], dp[i-1]<0
    //输入: [-2,1,-3,4,-1,2,1,-5,4],
    //输出: 6
    //解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
    public static int maxSubsequenceSum(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = (nums[0]>0?nums[0]:0);
        for(int i=1;i<n;i++){
            if(dp[i-1]>0)
                dp[i] = dp[i-1] + nums[i];
            else
                dp[i] = nums[i];
        }
        int max = 0;
        for(int i=0;i<n;i++)
            max = Math.max(max,dp[i]);
        return max;
    }

    public static void testMSS(int[] nums,int expected){
        System.out.println(maxSubsequenceSum(nums)==expected);
    }

    //最长回文子序列(不一定连续)
    //dp[i][j] 表示子串 s[i..j] 中，最长回文子序列的长度
    //已知dp[i + 1][j - 1]，来推导dp[i][j]
    //if (s[i] == s[j])
    //    // 它俩一定在最长回文子序列中
    //    dp[i][j] = dp[i + 1][j - 1] + 2;
    //else
    //    // s[i+1..j] 和 s[i..j-1] 谁的回文子序列更长？
    //    dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
    //i+1,j-1  -> i,j

    //i递减，j递增
    //base: dp[n-1][0] 不存在
    //dp[i][i] = 1，从每一个dp[i][i]开始
    //i<=j
    public static int maxPalindromeSequenceLength(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],1);
        int max = 1;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                    if (nums[i]==nums[j]&&i+1<=j-1) {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                    }else{
                        dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                    }
                    max = Math.max(max,dp[i][j]);
            }
        }
        //return max;
        return dp[0][n-1];
    }

    public static void testMPSequenceL(int[] nums,int expected){
        System.out.println(maxPalindromeSequenceLength(nums)==expected);
    }

    ////最长回文子序列(连续)
    //dp[i][j] = dp[i + 1][j - 1] + 2;   a[i]==a[j]&&dp[i+1][j-1]!=0
    //dp[i][j] = 0, a[i]!=a[j]
    //i递减，j递增
    public static int maxPalindromeSubstringLength(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],1);
        int max = 1;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j]) {
                    if(j-i<3)
                        dp[i][j] = j-i+1;
                    else if(dp[i+1][j-1]!=0){
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }else {
                        dp[i][j] = 0;
                    }
                    max = Math.max(max,dp[i][j]);
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

    public static void testMPSubstringL(int[] nums,int expected){
        System.out.println(maxPalindromeSubstringLength(nums)==expected);
    }


    //最长公共子序列(不需要连续)
    //dp[i][j] = d[i-1][j-1] + 1, a[i]==b[i]
    //dp[i][j] = max(dp[i-1][j],dp[i][j-1]), a[i]!=b[i]
    public static int longestCommonSubSequence(String str1,String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++)
            dp[i][0] = 0;
        for(int i=0;i<=len2;i++)
            dp[0][i] = 0;
        for(int i=1;i<=len1;i++){
            for (int j=1;j<=len2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[len1][len2];
    }

    public static void testLCSequence(String str1,String str2,int expected){
        System.out.println(longestCommonSubSequence(str1,str2)==expected);
    }


    //最长公共子串
    //dp[i][j] = d[i-1][j-1] + 1, a[i]==b[i]
    //dp[i][j] = 0, a[i]!=b[i]
    public static int longestCommonSubString(String str1,String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++)
            dp[i][0] = 0;
        for(int i=0;i<=len2;i++)
            dp[0][i] = 0;
        int max = 1;
        for(int i=1;i<=len1;i++){
            for (int j=1;j<=len2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max,dp[i][j]);
                } else
                    dp[i][j] = 0;
            }
        }
        return max;
    }

    public static void testLCSubstring(String str1,String str2,int expected){
        System.out.println(longestCommonSubString(str1,str2)==expected);
    }
}
