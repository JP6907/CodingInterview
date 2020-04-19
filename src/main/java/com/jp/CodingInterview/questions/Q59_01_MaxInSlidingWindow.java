package com.jp.CodingInterview.questions;

// 面试题59（一）：滑动窗口的最大值
// 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，
// 如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个
// 滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}，

import java.util.Deque;
import java.util.LinkedList;
import java.util.Vector;

public class Q59_01_MaxInSlidingWindow {

    static Vector<Integer> maxInWindows(int[] num,int size){
        assert size<num.length && size>=1;
        Deque<Integer> deque = new LinkedList<Integer>();
        Vector<Integer> maxInWindows = new Vector<Integer>();
        //先遍历到第一个窗口最后一位
        for(int i=0;i<size;i++){
            if(!deque.isEmpty()&&num[deque.getFirst()]<num[i])
                deque.pollFirst();
            deque.offerFirst(i);
        }
        for(int i=size;i<num.length;i++) {
            maxInWindows.add(num[deque.getFirst()]);
            //右边弹出小值，不可能成为最大值
            while (!deque.isEmpty()&&num[i]>num[deque.getLast()])
                deque.pollLast();
            //弹出左边超出边界的值
            while (!deque.isEmpty()&&deque.getFirst()<i-size+1)
                deque.pollFirst();
            deque.offerLast(i);
        }
        maxInWindows.add(num[deque.getFirst()]);
        return maxInWindows;
    }

    public static void main(String[] args){
        int[] num = {2,3,4,2,6,2,5,1};
        Vector<Integer> maxInWindows = maxInWindows(num,3);
        System.out.println(maxInWindows.toString());
    }
}
