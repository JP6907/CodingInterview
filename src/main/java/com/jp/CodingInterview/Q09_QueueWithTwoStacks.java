package com.jp.CodingInterview;

import java.util.Stack;

// 面试题9：用两个栈实现队列
// 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
// 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
public class Q09_QueueWithTwoStacks {

    private static class CQueue<T>{
        private Stack<T> stack1;
        private Stack<T> stack2;

        public CQueue() {
            stack1 = new Stack<T>();
            stack2 = new Stack<T>();
        }

        public void appendTail(T element){
            stack1.push(element);
        }

        public T deleteHead() throws Exception {
            //1.stack2为空，将stack1中的元素全部弹出，再按顺序压入stack2
            if(stack2.size()<=0){
                while(stack1.size()>0){
                    T data = stack1.pop();
                    stack2.push(data);
                }
            }
            //2.stack2为空，异常情况
            if(stack2.size()==0){
                throw new Exception("queue is empty!");
            }
            //3.stack2不为空，从stack2弹出一个元素返回
            return stack2.pop();
        }
    }

    public static void main(String[] args) throws Exception {
        CQueue<Integer> cQueue = new CQueue<Integer>();
        int[] data = {1,3,5,7,9,11};
        for(int d : data){
            cQueue.appendTail(d);
        }
        for(int i=0;i<data.length;i++){
            System.out.println(cQueue.deleteHead());
        }

    }
}
