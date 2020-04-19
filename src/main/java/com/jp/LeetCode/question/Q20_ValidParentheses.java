package com.jp.LeetCode.question;

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Note that an empty string is also considered valid.
//
//Example 1:
//
//Input: "()"
//Output: true
//Example 2:
//
//Input: "()[]{}"
//Output: true
//Example 3:
//
//Input: "(]"
//Output: false
//Example 4:
//
//Input: "([)]"
//Output: false
//Example 5:
//
//Input: "{[]}"
//Output: true

import java.util.Stack;

public class Q20_ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            switch (c){
                case '(' : stack.push(c); break;
                case '[' : stack.push(c); break;
                case '{' : stack.push(c); break;
                case ')' : if(stack.empty()||stack.peek()!='(') return false; else stack.pop(); break;
                case ']' : if(stack.empty()||stack.peek()!='[') return false; else stack.pop(); break;
                case '}' : if(stack.empty()||stack.peek()!='{') return false; else stack.pop(); break;
            }
        }
        return stack.empty();
    }

    public static void Test(String s,boolean expected){
        System.out.println(isValid(s)==expected);
    }

    public static void main(String[] args) {
        Test("()",true);
        Test("()[]{}",true);
        Test("([)]",false);
        Test("{[]}",true);
    }

}
