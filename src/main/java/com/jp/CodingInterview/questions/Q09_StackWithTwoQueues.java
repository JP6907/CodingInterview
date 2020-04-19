package com.jp.CodingInterview.questions;

import java.util.LinkedList;
import java.util.Queue;

// 用两个队列实现栈
public class Q09_StackWithTwoQueues {

    private static class QStack<T>{
        private Queue<T> queue1;
        private Queue<T> queue2;

        public QStack(){
            queue1 = new LinkedList<T>();
            queue2 = new LinkedList<T>();
        }

        public void push(T element){
            //两个队列都是空，则可以插入任意一个队列
            //有一个队列是非空的，插入非空的队列
            Queue<T> q = queue1.size()!=0?queue1:queue2;
            q.add(element);
        }

        public T pop() throws Exception {
            //找出目前非空的队列
            Queue<T> notEmptyQueue;
            Queue<T> emptyQueue;
            if(queue1.size()==0){
                emptyQueue = queue1;
                notEmptyQueue = queue2;
            }else{
                emptyQueue = queue2;
                notEmptyQueue = queue1;
            }
            //两个队列都是空，表示栈为空
            if(notEmptyQueue.size()==0){
                throw new Exception("Stack is empty!");
            }
            //一个队列非空，将非空队列数据依此取出插入另外一个队列
            while(notEmptyQueue.size()>1){
                T data = notEmptyQueue.remove();
                emptyQueue.add(data);
            }
            //最后一个元素不插入，弹出
            return notEmptyQueue.remove();
        }
    }

    public static void main(String[] args) throws Exception {
        QStack<Integer> stack = new QStack<Integer>();
        int[] data = {1,3,5,7,9,11};
        for(int d : data){
            stack.push(d);
        }
        for(int i=0;i<data.length;i++){
            System.out.println(stack.pop());
        }
        //stack.pop();
    }
}
