package com.jp.CodingInterview.questions;

// 面试题59（二）：队列的最大值
// 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，
// 如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个
// 滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}，
// 对比Q59_01_MaxInSlidingWindow，没有窗口限制
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Q59_02_QueueWithMax {

    static class QueueWithMax<T extends Comparable<T>>{

        private class InternalData{
            T number;
            int index;

            public InternalData(T number, int index) {
                this.number = number;
                this.index = index;
            }

            @Override
            public String toString() {
                return "" + number;
            }
        }

        Deque<InternalData> data = new LinkedList<>();
        Deque<InternalData> maximums = new LinkedList<>();
        int currentIndex = 0;

        public void push(T num){
            while (!maximums.isEmpty()&&num.compareTo(maximums.getLast().number)>0)
                maximums.pollLast();
            InternalData internalData = new InternalData(num,currentIndex++);
            maximums.offerLast(internalData);
            data.offerLast(internalData);
        }

        public T pop(){
            if(!maximums.isEmpty()){
                if(maximums.getFirst().index==data.getFirst().index)
                    maximums.pollFirst();
                T d = data.pollFirst().number;
                return d;
            }
            return null;
        }

        public T max(){
            if(!maximums.isEmpty()){
                return maximums.getFirst().number;
            }
            return null;
        }

        public String toString(){
            return Arrays.toString(data.toArray());
        }
    }

    public static void main(String[] args){
        int[] num = {2,3,4,2,6,2,5,1};
        QueueWithMax<Integer> queueWithMax = new QueueWithMax<>();
        for(int n:num){
            queueWithMax.push(n);
            System.out.println(queueWithMax.toString());
            System.out.println(queueWithMax.max());
        }
        for(int n:num){
            queueWithMax.pop();
            System.out.println(queueWithMax.toString());
            System.out.println(queueWithMax.max());
        }
    }
}

