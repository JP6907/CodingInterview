package com.jp.LeetCode.question;

//Given a string containing just the characters '(' and ')',
// find the length of the longest valid (well-formed) parentheses substring.
//
//Example 1:
//
//Input: "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()"
//Example 2:
//
//Input: ")()())"
//Output: 4
//Explanation: The longest valid parentheses substring is "()()"

// )()()((((
// ) 的下标减去 ( 的下表就表示长度
import java.util.Stack;

// 先找到第一个 (
public class Q32_LongestValidParentheses {
    // start 表示合法括号串的起始位置
    // 只有(会被入栈！入栈的时下表
    //( : 入栈
    //) : stack为空，start设置为下一个位置
    //    stack不为空，stack.peek 为 (，弹出 ,弹出后为空， len = i-start+1
    //                                             不为空 len = i-stack.top
    public static int longestValidParentheses(String s) {
        if(s==null||s.length()==0)
            return 0;
        int maxLength = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int start = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else{
                if(stack.empty()){
                    start = i+1;
                }else{
                    stack.pop();
                    if(stack.empty()){
                        maxLength = Math.max(maxLength,i-start+1);
                    }else{
                        maxLength = Math.max(maxLength,i-stack.peek());
                    }
                }
            }
        }
        return maxLength;
    }

    public static void Test(String s,int expected){
        System.out.println(longestValidParentheses(s)==expected);
    }

    public static void main(String[] args) {
        Test("(()",2);
        Test(")()())",4);
        Test("(",0);
    }

    public static int longestValidParentheses2(String s) {
        if(s == null || s.length() < 2){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            } else {
                if(!stack.empty()){
                    if(stack.peek() == '('){
                        max = Math.max(max, i-stack.peek()+1);
                    }
                }
            }
        }
    }
}

