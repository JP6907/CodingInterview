package com.jp.LeetCode.question;

/**
 * @author zjp
 * @createTime 2020/7/18 9:48
 **/
public class Q97_IsInterleave {



    public static void test(String s1, String s2, String s3, boolean expected){
        System.out.println(isInterleave2(s1, s2, s3) == expected);
        System.out.println("======");
    }

    public static void main(String[] args) {
        test("aabcc", "dbbca", "aadbbcbcac", true);
        test("aabcc", "dbbca", "aadbbbaccc", false);
    }

    //dp[i][j][k] = dp[i-1][j][k-1] || dp[i][j-1][k-1]  , s1[i] == s3[k] || s2[j] == s3[k]
    public static boolean isInterleave2(String s1, String s2, String s3) {
        if(s3.length() == 0 && (s1.length() != 0 || s2.length() !=0)){
            return false;
        }
        int[][][] memo = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        return isInterleaveCore2(s1, s2, s3, 0, 0, 0, memo);
    }

    public static boolean isInterleaveCore2(String s1, String s2, String s3,
                                            int index1, int index2, int index3, int[][][] memo) {
        if(index3 == s3.length()){
            return index1 == s1.length() && index2 == s2.length();
        }
        if(memo[index1][index2][index3] != 0){
            return memo[index1][index2][index3] == 1;
        }
        boolean result = false;
        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)){
            result |= isInterleaveCore2(s1, s2, s3, index1+1, index2, index3+1, memo);
        }
        if(!result && index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)){
            result |= isInterleaveCore2(s1, s2, s3, index1, index2+1, index3+1, memo);
        }
        memo[index1][index2][index3] = result?1:-1;
        return result;
    }

}
