package com.jp.question;

// 41：数据流中的中位数
// 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么
// 中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
// 那么中位数就是所有数值排序之后中间两个数的平均值。

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q41_StreamMedian {
    // 求中位数只需要利用到排序后的中间两个数
    //第一个数是左半部分的最大值
    //第二个数是右半部分的最小值
    //使用最大堆储存左半部分数据，最小堆储右半部分数据
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    });

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    boolean isEven = true; //总数是否位偶数，奇数：0

    public void Insert(Integer num){
        if(isEven){
            //插入最大堆
            //如果插入值比最小堆某些值大
            if(minHeap.size()>0&&num>minHeap.peek()){
                int tmp = minHeap.poll();
                maxHeap.add(tmp);
                minHeap.add(num);
            }else{
                maxHeap.add(num);
            }
            isEven = !isEven;
        }else{
            //插入最小堆
            //如果插入值比最大堆某些值小
            if(maxHeap.size()>0&&num<maxHeap.peek()){
                int tmp = maxHeap.poll();
                maxHeap.add(num);
                minHeap.add(tmp);
            }else{
                minHeap.add(num);
            }
            isEven = !isEven;
        }
    }

    public Double GetMedian(){
        if(!isEven){
            return (double)maxHeap.peek();
        }else{
            return ((double)maxHeap.peek()+(double)minHeap.peek())/2;
        }
    }


    public static void main(String[] args){
        Q41_StreamMedian SM = new Q41_StreamMedian();
        SM.Insert(5);
        System.out.println(SM.GetMedian().equals(5d));
        SM.Insert(2);
        System.out.println(SM.GetMedian().equals(3.5d));
        SM.Insert(3);
        System.out.println(SM.GetMedian().equals(3d));
        SM.Insert(4);
        System.out.println(SM.GetMedian().equals(3.5d));
        SM.Insert(1);
        System.out.println(SM.GetMedian().equals(3d));
        SM.Insert(6);
        System.out.println(SM.GetMedian().equals(3.5d));
        SM.Insert(7);
        System.out.println(SM.GetMedian().equals(4d));
        SM.Insert(0);
        System.out.println(SM.GetMedian().equals(3.5d));
        SM.Insert(8);
        System.out.println(SM.GetMedian().equals(4d));

    }
}
