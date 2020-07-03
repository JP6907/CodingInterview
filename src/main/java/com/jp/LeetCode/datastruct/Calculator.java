package com.jp.LeetCode.datastruct;

import com.sun.org.apache.xerces.internal.impl.dv.XSSimpleType;

import java.util.Stack;

/**
 * @author zjp
 * @Description
 * @createTime 9:14
 **/
public class Calculator {

    public int[] calculate(String s, int start){
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        if(!isDigit(s.charAt(start))){
            sign = s.charAt(start++);
        }
        int i = start;
        for(;i<s.length();i++){
            char c = s.charAt(i);
            if(isDigit(c)){
                num = num * 10 + (c - '0');
            }
            if(c == '('){
                int[] temp = calculate(s, i+1);
                num = temp[0];
                i = temp[1];
                continue;
            }
            if((!isDigit(c) && c != ' ') || i == s.length()-1){
                int pre;
                switch (sign){
                    case '+' :
                        stack.push(num);
                        break;
                    case '-' :
                        stack.push(-num);
                        break;
                    case '*':
                        pre = stack.pop();
                        num = pre*num;
                        stack.push(num);
                        break;
                    case '/':
                        pre = stack.pop();
                        num = pre/num;
                        stack.push(num);
                        break;
                }
                sign = c;
                num = 0;
            }
            if(c == ')'){
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return new int[]{res, i};
    }

    public void test(String s, int expected){
        System.out.println(calculate(s, 0)[0]==expected);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.test("1-12+3", -8);
        calculator.test("-1+12+3", 14);
        calculator.test("1*3-12*12+3", -138);
        calculator.test("1*3-(1+4/2)*12+3", -30);
    }

    public boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
}
