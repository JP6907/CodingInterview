package com.jp.LeetCode.question;

//Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
//
//You have the following 3 operations permitted on a word:
//
//Insert a character
//Delete a character
//Replace a character
//Example 1:
//
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation:
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
//Example 2:
//
//Input: word1 = "intention", word2 = "execution"
//Output: 5
//Explanation:
//intention -> inention (remove 't')
//inention -> enention (replace 'i' with 'e')
//enention -> exention (replace 'n' with 'x')
//exention -> exection (replace 'n' with 'c')
//exection -> execution (insert 'u')

import java.util.Arrays;

//https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E7%BC%96%E8%BE%91%E8%B7%9D%E7%A6%BB.md
public class Q72_EditDistance {

    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for(int i=0;i<memo.length;i++)
            Arrays.fill(memo[i],-1);
//        return dp(word1,word2,word1.length()-1,word2.length()-1,memo);
        return dp2(word1,word2,word1.length()-1,word2.length()-1,memo);
    }

    public int dp(String word1,String word2,int index1,int index2,int[][] memo){
        if(index1==-1)
            return index2+1;
        if(index2==-1)
            return index1+1;
        if(memo[index1][index2]!=-1)
            return memo[index1][index2];
        int result = 0;
        if(word1.charAt(index1)==word2.charAt(index2)) {
            result =  dp(word1, word2, index1 - 1, index2 - 1, memo);

        }else {
            result = min(dp(word1,word2,index1,index2-1,memo)+1,  //插入
                    dp(word1,word2,index1-1,index2,memo)+1,     //删除
                    dp(word1,word2,index1-1,index2-1,memo)+1);  //替换
        }
        memo[index1][index2] = result;
        return result;
    }

    public int min(int num1,int num2,int num3){
        return Math.min(Math.min(num1,num2),num3);
    }


    public void test(String word1,String word2,int expected){
        System.out.println(minDistance(word1,word2)==expected);
        System.out.println(minDistance2(word1,word2)==expected);
        System.out.println(minDistance3(word1,word2)==expected);
        System.out.println(minDistance4(word1,word2)==expected);
    }

    public static void main(String[] args) {
        Q72_EditDistance ed = new Q72_EditDistance();
        ed.test("horse","ros",3);
        ed.test("intention","execution",5);
    }

    public int dp2(String word1,String word2,int index1,int index2,int[][] memo){
        //处理边界
        if(index1==-1){
            return index2+1;
        }
        if(index2==-1){
            return index1+1;
        }
        if(memo[index1][index2]!=-1)
            return memo[index1][index2];
        else {
            int result;
            if(word1.charAt(index1)==word2.charAt(index2)){
                result = dp2(word1,word2,index1-1,index2-1,memo);
            }else {
                result = min(dp2(word1,word2,index1,index2-1,memo), //插入，在index1后面插入一个和index2一样的字符
                            dp2(word1,word2,index1-1,index2,memo), //删除，删除index1，取下一个和index2比较
                            dp2(word1,word2,index1-1,index2-1,memo))+1; //替换，将index1替换成index2
            }
            memo[index1][index2] = result;
            return result;
        }
    }

    //非递归方式
    public int minDistance2(String word1, String word2){
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            dp[i][0] = i;
        }
        for(int i=1;i<=len2;i++){
            dp[0][i] = i;
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
                }
            }
        }
        return dp[len1][len2];
    }

    public int minDistance3(String word1, String word2){
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            dp[i][0] = i;
        }
        for(int i=0;i<=len2;i++){
            dp[0][i] = i;
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }

    public int minDistance4(String word1, String word2){
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] memo = new int[len1][len2];
        for(int i=0;i<len1;i++){
            Arrays.fill(memo[i], -1);
        }
        return minDistanceCore4(word1, word2, len1-1, len2-1, memo);
    }

    public int minDistanceCore4(String word1, String word2, int index1, int index2, int[][] memo){
        if(index1==0) {
            return index2+1;
        }
        if(index2==0){
            return index1+1;
        }
        if(memo[index1][index2]!=-1){
            return memo[index1][index2];
        }else {
            int result = 0;
            if(word1.charAt(index1) == word2.charAt(index2)){
                result = minDistanceCore4(word1, word2, index1-1, index2-1, memo);
            }
            else {
                result = min(minDistanceCore4(word1, word2, index1, index2 - 1, memo),
                        minDistanceCore4(word1, word2, index1 - 1, index2, memo),
                        minDistanceCore4(word1, word2, index1 - 1, index2 - 1, memo)) + 1;
            }
            memo[index1][index2] = result;
            return result;
        }

    }

}
