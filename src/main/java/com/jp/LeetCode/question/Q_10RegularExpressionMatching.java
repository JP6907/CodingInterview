package com.jp.LeetCode.question;

//Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
//
//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
//The matching should cover the entire input string (not partial).
//
//Note:
//
//s could be empty and contains only lowercase letters a-z.
//p could be empty and contains only lowercase letters a-z, and characters like . or *.
//Example 1:
//
//Input:
//s = "aa"
//p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
//Example 2:
//
//Input:
//s = "aa"
//p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//Example 3:
//
//Input:
//s = "ab"
//p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
//Example 4:
//
//Input:
//s = "aab"
//p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
//Example 5:
//
//Input:
//s = "mississippi"
//p = "mis*is*p*."
//Output: false
public class Q_10RegularExpressionMatching {

    public static boolean isMatch(String s, String p) {
        if(s.length()!=0&&p.length()!=0)
            return isMatchCore(s,p,0,0);
        else
            return false;
    }

    public static boolean isMatchCore(String str,String pattern,int indexStr,int indexPatt){
        if(indexStr==str.length()&&indexPatt==pattern.length())
            return true;
        if(indexStr!=str.length()&&indexPatt==pattern.length())
            return false;
        if(pattern.charAt(indexPatt+1)=='*'){
            if(str.charAt(indexStr)==pattern.charAt(indexPatt)||
                    (pattern.charAt(indexPatt)=='.'&&indexStr!=str.length())){
                return isMatchCore(str,pattern,indexStr+1,indexPatt+2)  //匹配一个
                      || isMatchCore(str,pattern,indexStr+1,indexPatt) //多个
                      || isMatchCore(str,pattern,indexStr,indexPatt+2); //0个
                }else{
                    //ignore a '*'
                    return isMatchCore(str,pattern,indexStr,indexPatt+2); //0个
                }
        }
        if(str.charAt(indexStr)==pattern.charAt(indexPatt)||(pattern.charAt(indexPatt)=='.'&&indexStr!=str.length()))
            return isMatchCore(str,pattern,indexStr+1,indexPatt+1);

        return false;
    }

    public static void Test(String s,String p,boolean expected){
        System.out.println(isMatch(s,p)==expected);
    }

    public static void main(String[] args) {
        Test("aa","a",false);
        Test("aa","a*",true);
        Test("ab",".*",true);
        Test("aab","c*a*b",true);
        Test("mississippi","mis*is*p*.",false);
        Test("aaa","a*a",true);
    }
}
