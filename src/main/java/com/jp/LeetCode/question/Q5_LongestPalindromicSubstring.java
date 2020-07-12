package com.jp.LeetCode.question;

import javax.swing.*;
import java.util.Arrays;

//Given a string s, find the longest palindromic substring in s.
// You may assume that the maximum length of s is 1000.
//
//Example 1:
//
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//Example 2:
//
//Input: "cbbd"
//Output: "bb"
public class Q5_LongestPalindromicSubstring {
    //从每一个位置的字母往两边对比
    //两种情况
    //index和两边都不同U
    //index和index+1相同
    public static String longestPalindrome(String s) {
        if(s.length()<2)
            return s;
        int len = 0;
        int maxLen = Integer.MIN_VALUE;
        String result = "";
        for(int i=0;i<s.length();i++){
            String paliStr = HaflPalindrome(s,i,true);
            len = 2*(paliStr.length()-1)+1;
            if(len>maxLen){
                maxLen = len;
                result = getPalindrome(paliStr,true);
            }
            paliStr = HaflPalindrome(s,i,false);
            len = 2*paliStr.length();
            if(len>maxLen){
                maxLen = len;
                result = getPalindrome(paliStr,false);
            }
        }
        return result;
    }
    //flag true: index为中心
    //flag false: index=index+1
    public static String HaflPalindrome(String s,int index,boolean flag){
        StringBuilder sb = new StringBuilder();
        int left = index - 1;
        int right;
        if(flag){
            right = index+1;
            sb.append(s.charAt(index));
        }else {
            right = index+2;
            if(index+1<s.length()&&s.charAt(index)==s.charAt(index+1))
                sb.append(s.charAt(index+1));
            else
                return sb.toString();
        }
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            sb.append(s.charAt(right));
            left--;
            right++;
        }
        return sb.toString();
    }

    public static String getPalindrome(String s,boolean flag){
        StringBuilder sb = new StringBuilder(s).reverse();
        if(flag)
            sb.append(s.substring(1,s.length()));
        else
            sb.append(s.substring(0,s.length()));
        return sb.toString();
    }

    ////简洁的实现方法
    public static String longestPalindrome2(String s){
        String result = "";
        for(int i=0;i<s.length();i++){
            String s1 = palindrome2(s,i,i);
            String s2 = palindrome2(s,i,i+1);
            result = (result.length()>s1.length()?result:s1);
            result = (result.length()>s2.length()?result:s2);
        }
        return result;
    }

    public static String palindrome2(String s,int l,int r){
        while (l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }

    ///动态规划
    //dp[i][j]表示i到j是否为回文串
    //当s[i]==s[j]且dp[i+1][j-1]为true，则dp[i][j]为true
    //迭代过程i是递减的，j是递增的，且i<j
    //dp[i][i]默认为true
    public static String longestPalindrome3(String s){
        if(s.length()==0)
            return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int left=0,right=0;
        for(int i=n-2;i>=0;i--){
            dp[i][i] = true;
            for(int j=i+1;j<n;j++){
                if(s.charAt(i)==s.charAt(j))
                    dp[i][j] = (j-i<3)||dp[i+1][j-1];
                if(dp[i][j]&&j-i>right-left){
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left,right+1);
    }


    public static void Test(String s,String expected1,String expected2){
        System.out.println(longestPalindrome(s).equals(expected1) || longestPalindrome(s).equals(expected2));
        System.out.println(longestPalindrome2(s).equals(expected1) || longestPalindrome(s).equals(expected2));
        System.out.println(longestPalindrome3(s).equals(expected1) || longestPalindrome(s).equals(expected2));
        System.out.println(longestPalindrome4(s).equals(expected1) || longestPalindrome(s).equals(expected2));
        System.out.println(longestPalindrome5(s).equals(expected1) || longestPalindrome(s).equals(expected2));
        System.out.println(longestPalindrome6(s).equals(expected1) || longestPalindrome6(s).equals(expected2));
        System.out.println(longestPalindrome7(s).equals(expected1) || longestPalindrome7(s).equals(expected2));
        System.out.println("===");
    }

    public static void main(String[] args) {
        Test("babad","aba", "bab");
        Test("cbbd","bb", "");
        Test("abcdasdfghjkldcba","a", "a");
    }

    //动态规划
    //dp[i][j]表示 (i,j)是不是回文串
    //s[i]==s[j] && dp[i+1][j-1]==true ：dp[i][j]=true
    //s[i]!=s[j] : dp[i][j]=false
    //依赖于左下角
    //判断(i,j)时需要保证(i+1,j-1)已经判断了
    //i降序、j升序
    public static String longestPalindrome4(String s){
        int n = s.length();
        if(n <= 1){
            return s;
        }else {
            boolean[][] dp = new boolean[n][n];
            for(int i=0;i<n;i++){
                Arrays.fill(dp[i], false);
            }
            for(int i=0;i<n;i++){
                dp[i][i] = true;
            }
            int max = 1;
            int left = 0, right = 0;
            for(int i=n-2;i>=0;i--){
                for(int j=i+1;j<n;j++){
                    if(s.charAt(i)==s.charAt(j) && (dp[i+1][j-1] || j-i<3)){
                        dp[i][j] = true;
                    }
                    if(dp[i][j] && j-i+1>max){
                        left = i;
                        right = j;
                        max = right-left+1;
                    }
                }
            }
            return s.substring(left, right+1);
        }
    }

    public static String longestPalindrome5(String s){
        if(s.length()<=1){
            return s;
        }
        String result = "";
        for(int i=0;i<s.length();i++){
            String s1 = longestPalindromeCore5(s, i, i);
            String s2 = longestPalindromeCore5(s, i, i+1);
            result = result.length()>s1.length()?result:s1;
            result = result.length()>s2.length()?result:s2;
        }
        return result;
    }

    public static String longestPalindromeCore5(String s, int left, int right){
        if(left>=0 && right<s.length() && left!=right && s.charAt(left)!=s.charAt(right))
            return "";
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }


    public static String longestPalindrome6(String s) {
        String result = "";
        for(int i=0;i<s.length()-1;i++){
            String str1 = longestPalindromeCore6(s,i, i+1);
            String str2 = longestPalindromeCore6(s,i, i);
            result = str1.length() > result.length() ? str1 : result;
            result = str2.length() > result.length() ? str2 : result;
        }
        return result;
    }

    public static String longestPalindromeCore6(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }

    //dp[i][j]表示 [i,j]回文字串的长度
    //dp[i][i] = 1
    //i <= j
    //dp[i][j] = dp[i+1][j-1] .....
    public static String longestPalindrome7(String s) {
        int n = s.length();
        if(n == 0){
            return "";
        }
        int[][] dp = new int[n][n];
        String result = s.substring(0, 1);
        for(int i=0;i<n;i++){
            dp[i][i] = 1;
        }
        for(int k=1;k<n;k++){
            for(int i=0;i<n-k;i++){
                int left = i;
                int right = i+k;
                if((right-left+1 <= 3 || dp[left+1][right-1] > 0) && s.charAt(left) == s.charAt(right)){
                    dp[left][right] = dp[left+1][right-1] + 2;
                    if(right-left+1 > result.length()){
                        result = s.substring(left, right+1);
                    }
                }else {
                    dp[left][right] = 0;
                }
            }
        }
        return result;
    }
}
