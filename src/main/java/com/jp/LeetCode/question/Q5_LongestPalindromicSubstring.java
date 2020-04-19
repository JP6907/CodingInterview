package com.jp.LeetCode.question;

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


    public static void Test(String s,String expected){
        System.out.println(longestPalindrome(s).equals(expected));
        System.out.println(longestPalindrome2(s).equals(expected));
        System.out.println(longestPalindrome3(s).equals(expected));
    }

    public static void main(String[] args) {
        Test("babad","bab");
        Test("cbbd","bb");
        Test("abcdasdfghjkldcba","a");
    }

}
