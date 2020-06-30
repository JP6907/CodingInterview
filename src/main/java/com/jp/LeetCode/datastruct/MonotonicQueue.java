package com.jp.LeetCode.datastruct;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调队列
 * https://github.com/labuladong/fucking-algorithm/blob/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E7%B3%BB%E5%88%97/%E5%8D%95%E8%B0%83%E9%98%9F%E5%88%97.md
 * @author zjp
 * @Description
 * @createTime 20:16
 **/
public class MonotonicQueue {
    private Deque<Integer> data;

    public MonotonicQueue() {
        data = new LinkedList<>();
    }

    public void push(int n){
        while (!data.isEmpty() && data.peekLast()<n){
            data.pollLast();
        }
        data.addLast(n);
    }

    public int max(){
        return data.peekFirst();
    }

    public void pop(int n){
        if(!data.isEmpty() && data.peekFirst()==n){
            data.pollFirst();
        }
    }

}
