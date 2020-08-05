package com.jp.LeetCode.question;

/**
 * @author shangqiu
 * @createTime 2020/7/27
 **/
public class Q392_isSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        if(lens == 0){
            return true;
        }
        if (lent == 0){
            return false;
        }
        int indext = 0, indexs = 0;
        while (indexs < lens && indext < lent){
            if(s.charAt(indexs) == t.charAt(indext)){
                indexs++;
            }
            indext++;
            if(indexs == lens){
                return true;
            }
        }
        return false;
    }

    public static void test(String s, String t, boolean expected){
        System.out.println(isSubsequence(s, t) == expected);
    }

    public static void main(String[] args) {
        test("abc", "ahbgdc", true);
        test("axc", "ahbgdc", false);
    }
}
