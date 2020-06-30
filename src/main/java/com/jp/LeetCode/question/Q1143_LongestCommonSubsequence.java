package com.jp.LeetCode.question;

/**
 * @author zjp
 * @Description
 * @createTime 9:06
 **/
public class Q1143_LongestCommonSubsequence {

    //s1[i]==s2[j] dp[i][j] = dp[i-1][j-1]+1
    //s1[i]!=s2[j] dp[i][j] = Max{dp[i-1][j],dp[i][j-1]}
    public static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if(len1 == 0 || len2 == 0){
            return 0;
        }
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=len2;i++){
            dp[0][i] = 0;
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    public static void test(String s1, String s2, int expected){
        System.out.println(longestCommonSubsequence(s1, s2) == expected);
    }

    public static void main(String[] args) {
        test("abcde", "ace", 3);
        test("abc", "abc", 3);
        test("abc", "def", 0);
    }

}

