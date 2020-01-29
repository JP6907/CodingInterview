package com.jp.question;

import java.util.List;
import java.util.Stack;

// 面试题31：栈的压入、弹出序列
// 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
// 否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、
// 5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但
// 4、3、5、1、2就不可能是该压栈序列的弹出序列。
public class Q31_StackPushPopOrder {

    public static boolean IsPopOrder(int[] pushA,int[] popA){
        if(pushA.length!=popA.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int i=0,j=0;
        for(;i<pushA.length;i++){
            stack.push(pushA[i]);
            while (!stack.empty()&&stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        if(j!=popA.length)
            return false;
        else
            return true;
    }

    public static void Test(int[] pushA,int[] popA,boolean expected){
        System.out.println(IsPopOrder(pushA,popA)==expected);
    }

    public static void main(String[] args){
        Test(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1},true);
        Test(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2},false);
        Test(new int[]{1,2,3,4,5},new int[]{3, 5, 4, 2, 1},true);
        Test(new int[]{1,2,3,4,5},new int[]{3, 5, 4, 1, 2},false);
        Test(new int[]{1},new int[]{2},false);
        Test(new int[]{1},new int[]{1},true);
    }
}
