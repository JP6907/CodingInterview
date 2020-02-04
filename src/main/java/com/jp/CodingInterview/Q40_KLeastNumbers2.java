package com.jp.CodingInterview;

// 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Q40_KLeastNumbers2 {

    //使用堆，大根堆，根为k个最小数中的最大值
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
        if(k<=0||input.length<k)
            return new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int n : input){
            if(heap.size()<k){
                heap.offer(n);
            }else if(heap.peek()>n){
                heap.poll();
                heap.offer(n);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        Iterator<Integer> iter = heap.iterator();
        while (iter.hasNext()){
            result.add(iter.next());
        }
        return result;
    }

    public static void Test(int[] input,int k){
        ArrayList<Integer> result = GetLeastNumbers_Solution(input,k);
        System.out.println(result.toString());
    }


    public static void main(String[] args){
        Test(new int[]{4,5,1,6,2,7,3,8},4);
        Test(new int[]{9,8,7,6,5,4,3,2,1,10},4);
        Test(new int[]{4,5,1,6,2,7,3,8},10);
    }
}
