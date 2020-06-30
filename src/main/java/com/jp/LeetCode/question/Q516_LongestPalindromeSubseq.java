package com.jp.LeetCode.question;

/**
 * 最长回文子序列，可以不连续
 * @author zjp
 * @Description
 * @createTime 16:07
 **/
public class Q516_LongestPalindromeSubseq {
    //s[i]==s[j] dp[i][j] = dp[i+1][j-1]+2
    //s[i]!=s[j] dp[i][j] = Max{dp[i+1][j],dp[i][j-1]}
    //依赖于左边和下面。斜着遍历
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n<=1){
            return n;
        }else {
            int[][] dp = new int[n][n];
            for(int i=0;i<n;i++){
                dp[i][i] = 1;
            }
            for(int k=1;k<n;k++){
                for(int i=0;i<n-k;i++){
                    int row = i;
                    int col = i+k;
                    if(s.charAt(row)==s.charAt(col)){
                        dp[row][col] = dp[row+1][col-1]+2;
                    }else {
                        dp[row][col] = Math.max(dp[row+1][col], dp[row][col-1]);
                    }
                }
            }
            return dp[0][n-1];
        }
    }

    public static void test(String s, int expected){
        System.out.println(longestPalindromeSubseq(s)==expected);
    }

    public static void main(String[] args) {
        test("bbbab", 4);
        test("cbbd", 2);
    }

}
