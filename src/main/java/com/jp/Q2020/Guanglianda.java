package com.jp.Q2020;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Guanglianda {

    //样例输入
    //5
    //3 3 4 4 5
    //样例输出
    //12
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //大顶堆
        PriorityQueue<Long> heap = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return -o1.compareTo(o2);
            }
        });
        for(int i=0;i<n;i++){
            heap.add(sc.nextLong());
        }
        int index = 0;
        long curr = heap.poll();
        long[] line = new long[4];
        while (!heap.isEmpty()){
            long peek = heap.poll();
            if(peek == curr){
                line[index++] = curr;
                line[index++] = curr;
            } else {
                curr = peek;
            }
            if(index == 4){
                break;
            }
        }
        long result = 0;
        if(index == 4){
            result = line[0]*line[2];
        } else {
            result = -1;
        }
        System.out.println(result);
    }
}
