package com.jp.question;

// 面试题65：不用加减乘除做加法
// 题目：写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷
// 四则运算符号。

public class Q65_AddTwoNumbers {

    // 三步走
    // 1. 各位相加不考虑进位  异或
    // 2. 计算进位，只有两个数都是1才进位， 与 ，然后左移
    // 1，2的结果相加，直至不产生进位
    static int Add(int num1,int num2){
        int sum=0,carry=0;
        do{
            sum = num1^num2;
            carry = (num1&num2)<<1;
            num1 = sum;
            num2 = carry;
        }while (carry!=0);
        return sum;
    }

    public static void main(String[] args){
        System.out.println(Add(2,112));
        System.out.println(Add(231,12));
        System.out.println(Add(5,11));
        System.out.println(Add(0,112));
        System.out.println(Add(-1,-123));
    }
}
