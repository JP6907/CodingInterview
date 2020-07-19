package com.jp.LeetCode.question;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;

/**
 * 字符串问题
 * @author zjp
 * @createTime 2020/7/18 15:55
 **/
public class StringQuestion {

    public static void main(String[] args) {

        //最长递增子序列
//        test1(new int[]{10,9,2,5,3,7,101,18}, 4);
//        test1(new int[]{1,3,6,7,9,4,10,5,6}, 6);

        //最长递增子串
//        test2(new int[]{1,4,3,6,8,10},4);

        //最大子序和
//        test3(new int[]{-2,1,-3,4,-1,2,1,-5,4}, 6);

        //最长回文子序列
//        test4("bbbab", 4);
//        test4("cbbd", 2);

        //最长重复子数组
//        test5(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}, 3);
//        test5(new int[]{0,1,1,1,1}, new int[]{1,0,1,0,1}, 2);

        //最长公共子序列
//        test6("abcde", "ace", 3);
//        test6("abc", "abc", 3);
//        test6("abc", "def", 0);

        //最长回文子串
        test7("babad", "bab", "aba");
        test7("ac", "a", "c");
    }



    //300. 最长递增子序列
    public static int q1_lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static void test1(int[] nums, int expected){
        System.out.println(q1_lengthOfLIS(nums) == expected);
    }

    //最长递增子串
    public static int q2_lengthOfLISustring(int[] nums){
        int len = nums.length;
        if(len <= 1){
            return len;
        }
        int count = 1;
        int max = 1;
        for(int i=1;i<len;i++){
            if(nums[i] > nums[i-1]){
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }
        return max;
    }

    public static void test2(int[] nums, int expected){
        System.out.println(q2_lengthOfLISustring(nums) == expected);
    }


    //53. 最大子序和
    //dp[i] 表示nums中以i结尾的最大子序列和
    //if dp[i-1]>0 dp[i] = dp[i] + nums[i]
    //else  dp[i] = nums[i]
    public static int q3_maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1;i<len;i++){
            if(dp[i-1] > 0){
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void test3(int[] nums, int expected){
        System.out.println(q3_maxSubArray(nums) == expected);
    }


    //516. 最长回文子序列
    //if s[i]==s[j]  dp[i][j] = dp[i+1][j-1]+2
    //else dp[i][j] = Max{dp[i+1][j], dp[i][j-1]}
    //依赖于左下方
    public static int q4_longestPalindromeSubseq(String s) {
        int len = s.length();
        if(len <= 1){
            return len;
        }
        int[][] dp = new int[len][len];
        for(int i=0;i<len;i++){
            dp[i][i] = 1;
        }
        for(int k=1;k<len;k++){
            for(int i=0;i<len-k;i++){
                int row = i;
                int col = i + k;
                if(s.charAt(row) == s.charAt(col)){
                    dp[row][col] = dp[row+1][col-1] + 2;
                }else {
                    dp[row][col] = Math.max(dp[row+1][col], dp[row][col-1]);
                }

            }
        }

        return dp[0][len-1];
    }

    public static void test4(String s, int expected){
        System.out.println(q4_longestPalindromeSubseq(s) == expected);
    }


    //718. 最长重复子数组
    //dp[i][j] = dp[i-1][j-1] + 1
    public static int q5_findLength(int[] A, int[] B) {
         int len1 = A.length;
         int len2 = B.length;
         if(len1 == 0 || len2 == 0){
             return 0;
         }
         int[][] dp =  new int[len1+1][len2+1];
         int max = 0;
         for(int i=1;i<=len1;i++){
             for(int j=1;j<=len2;j++){
                 if(A[i-1] == B[j-1]){
                     dp[i][j] = dp[i-1][j-1] + 1;
                 } else {
                     dp[i][j] = 0;
                 }
                 max = Math.max(max, dp[i][j]);
             }
         }
         return max;
    }

    public static void test5(int[] A, int[] B, int expected){
        System.out.println(q5_findLength(A, B) == expected);
    }


    //1143. 最长公共子序列
    //if s1[i]==s2[j]： dp[i][j] = dp[i-1][j-1]
    //if s1[i]!=s2[j]： dp[i][j] = Max{dp[i-1][j], dp[i][j-1]}
    //递归解法
    public static int q6_longestCommonSubsequence(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            Arrays.fill(memo[i], -1);
        }
        return longestCommonSubsequenceCore(text1, text2, text1.length()-1, text2.length()-1, memo);
    }

    public static int longestCommonSubsequenceCore(String text1, String text2, int index1, int index2, int[][] memo) {
        if(index1 == -1 || index2 == -1){
            return 0;
        }
        if(memo[index1][index2] != -1){
            return memo[index1][index2];
        }
        int result = 0;
        if(text1.charAt(index1) == text2.charAt(index2)){
            result = 1 + longestCommonSubsequenceCore(text1, text2, index1-1, index2-1, memo);
        } else {
            result = Math.max(longestCommonSubsequenceCore(text1, text2, index1-1, index2, memo),
                    longestCommonSubsequenceCore(text1, text2, index1, index2-1, memo));
        }
        memo[index1][index2] = result;
        return result;
    }

    //if s1[i]==s2[j]： dp[i][j] = dp[i-1][j-1]
    //if s1[i]!=s2[j]： dp[i][j] = Max{dp[i-1][j], dp[i][j-1]}
    //迭代解法
    public static int q6_longestCommonSubsequence2(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        if(len1 == 0 || len2 == 0){
            return 0;
        }
        int[][] dp =  new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }


    public static void test6(String text1, String text2, int expected){
        System.out.println(q6_longestCommonSubsequence(text1, text2) == expected);
        System.out.println(q6_longestCommonSubsequence2(text1, text2) == expected);
    }

    //5. 最长回文子串
    public static String q7_longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1){
            return s;
        }
        String result = "";
        for(int i=0;i<len-1;i++){
            String str1 = q7_longestPalindromeHelper(s, i, i);
            String str2 = q7_longestPalindromeHelper(s, i, i+1);
            result = str1.length()>result.length()?str1:result;
            result = str2.length()>result.length()?str2:result;
        }
        return result;
    }

    public static String q7_longestPalindromeHelper(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }


    //dp[i][j] = dp[i+1][j-1]+2
    public static String q7_longestPalindrome2(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int[][] dp =  new int[len][len];
        for(int i=0;i<len;i++){
            dp[i][i] = 1;
        }
        String result = s.substring(0,1);
        for(int k=1;k<len;k++){
            for(int i=0;i<len-k;i++){
                int row = i;
                int col = i+k;
                if(s.charAt(row) == s.charAt(col) && (row+1 >= col-1 || dp[row+1][col-1] >= 0)){
                    dp[row][col] = dp[row+1][col-1] + 2;
                    if(dp[row][col] > result.length()) {
                        result = s.substring(row, col + 1);
                    }
                }else {
                    dp[row][col] = -1;
                }
            }
        }
        return result;


    }
    public static void test7(String s, String expected1, String expected2){
        String result1 = q7_longestPalindrome(s);
        String result2 = q7_longestPalindrome2(s);
        System.out.println(result1.equals(expected1) || result1.equals(expected2));
        System.out.println(result2.equals(expected1) || result2.equals(expected2));

    }

}
