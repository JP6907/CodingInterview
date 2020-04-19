package com.jp.LeetCode.question;

import java.util.ArrayList;
import java.util.List;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//For example, given n = 3, a solution set is:
//
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
public class Q22_GenerateParentheses {

    //回缩法
    //记录当前已经添加的 ( 或 ) 数量
    //如果 ( 数量小于n，则可以继续添加 (
    //如果 ) 数量小于 ( ,则可以继续添加 (
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        genetateParenthesisCore(0,0,n,result,"");
        return result;
    }

    public static void genetateParenthesisCore(int open,int close,int n,List<String> result,String curr){
        if(curr.length()==2*n){
            result.add(curr);
        }
        if(open<n){
            genetateParenthesisCore(open+1,close,n,result,curr+"(");
        }
        if(close<open){
            genetateParenthesisCore(open,close+1,n,result,curr+")");
        }
    }

    public static void Test(int n){
        List<String> result = generateParenthesis(n);
        for(String r : result){
            System.out.println(r);
        }
    }

    public static void main(String[] args) {
        Test(3);
    }

}
