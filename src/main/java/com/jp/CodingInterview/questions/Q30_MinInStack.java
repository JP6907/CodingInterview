package com.jp.CodingInterview.questions;

import java.util.Stack;

// 面试题30：包含min函数的栈
// 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min
// 函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。
public class Q30_MinInStack {

    public static class StackWithMin<T extends Comparable<T>>{
        private Stack<T> dataStack;
        private Stack<T> minStack;  //和dataStack保持同步更新，top为当前的最小值

        public StackWithMin() {
            dataStack = new Stack<T>();
            minStack = new Stack<T>();
        }

        public void push(T value){
            dataStack.push(value);

            if(minStack.empty()||value.compareTo(minStack.peek())<0)
                minStack.push(value);
            else
                minStack.push(minStack.peek());
        }

        public T pop(){
            assert dataStack.size()>0 && minStack.size()>0;
            minStack.pop();
            return dataStack.pop();
        }

        public T min(){
            assert minStack.size()>0;
            return minStack.peek();
        }

        public int size(){
            return dataStack.size();
        }
    }

    public static void main(String[] args){
        StackWithMin<Integer> minStack = new StackWithMin<Integer>();
        Integer[] data = new Integer[]{5,3,4,2,6,-1};
        for(Integer i : data){
            minStack.push(i);
            System.out.println(minStack.min());
        }
        System.out.println("================");
        while (minStack.size()>0){
            System.out.println(minStack.min());
            minStack.pop();
        }
    }
}
