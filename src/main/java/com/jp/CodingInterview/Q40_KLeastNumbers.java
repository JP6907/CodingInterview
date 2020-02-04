package com.jp.CodingInterview;

import java.util.*;

// 面试题40：最小的k个数
// 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
// 这8个数字，则最小的4个数字是1、2、3、4。
public class Q40_KLeastNumbers {

    //解法一：排序 O(nlogn)
    //解法二：快速排序的思想 O(n)

    //解法三：辅助容器 O(nlogk)  特别适合处理海量数据
    //构造一个大小为k的容器来存放最小的k个数字
    //容器使用最大堆
    static List<Integer> getLeastNumbers(List<Integer> data,int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(Integer d : data){
            if(maxHeap.size()<k)
                maxHeap.offer(d);
            else{
                //堆中的最大值大于d，则删除目前的最大值，插入d
                if(maxHeap.peek()>d){
                    maxHeap.poll();
                    maxHeap.offer(d);
                }
                //否则，d不可能是k个最小值之一
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> iter = maxHeap.iterator();
        while (iter.hasNext()){
            result.add(iter.next());
        }
        return result;
    }

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(9,8,7,6,5,4,3,2,1,10);
        int k = 4;
        List<Integer> leastK = getLeastNumbers(list,k);
        System.out.println(leastK.toString());

    }

}
