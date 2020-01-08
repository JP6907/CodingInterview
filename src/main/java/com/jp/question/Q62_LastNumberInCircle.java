package com.jp.question;

// 面试题62：圆圈中最后剩下的数字
// 题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里
// 删除第m个数字。求出这个圆圈里剩下的最后一个数字

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Q62_LastNumberInCircle {

    static int LastRemaining_Solution1(int n,int m){
        if(n < 1 || m < 1)
            return -1;

        LinkedList<Integer> numbers = new LinkedList<Integer>();
        for(int i=0;i<n;i++)
            numbers.add(i);

        Iterator<Integer> iter = numbers.iterator();
        iter.next(); //移动到第一个元素
        while (numbers.size()>1){
            for(int i=1;i<m;i++){
                if(iter.hasNext())
                    iter.next();
                else {
                    iter = numbers.iterator();
                    iter.next(); //移动到第一个元素
                }
            }
            //iter当前的值是需要删除的
            if(iter.hasNext()) {
                iter.remove(); //remove指针会向后移动
                iter.next();
            }else{//最后一个节点
                iter.remove();
                iter = numbers.iterator();
                iter.next();
            }
        }
        return numbers.getFirst();
    }

    static boolean TestLastRemaining(int n,int m,int expected){
        return LastRemaining_Solution1(n,m)==expected;
    }

    static void test(int n){
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        for(int i=0;i<n;i++)
            numbers.add(i);

        Iterator<Integer> iter = numbers.iterator();
        while (iter.hasNext()){
            int next = iter.next();
            if(next==2)
                iter.remove();
            else
                System.out.println(next);
        }
        System.out.println(numbers.size());
    }

    public static void main(String[] args){
        System.out.println(TestLastRemaining(5,3,3));
        System.out.println(TestLastRemaining(5, 2,2));
        System.out.println(TestLastRemaining( 6, 7,4));
        System.out.println(TestLastRemaining( 6, 6,3));
        System.out.println(TestLastRemaining( 0, 0,-1));
        System.out.println(TestLastRemaining( 4000, 997,1027));

    }
}
