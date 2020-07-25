package com.jp.LeetCode.ByteDance;

import java.util.Stack;

/**
 * @author zjp
 * @createTime 2020/7/25 23:27
 **/
public class Q_MinStack {

    public static class MinStack{

        Stack<Integer> dataStack;
        Stack<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if(minStack.empty()){
                minStack.push(x);
            } else {
                if(x < minStack.peek()){
                    minStack.push(x);
                } else {
                    minStack.push(minStack.peek());
                }
            }
        }

        public void pop() {
            if(!dataStack.empty()){
                dataStack.pop();
                minStack.pop();
            }
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin() == -3);  // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top() == 0);     // --> 返回 0.
        System.out.println(minStack.getMin() == -2);  // --> 返回 -2.
    }
}
