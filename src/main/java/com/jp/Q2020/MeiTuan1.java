package com.jp.Q2020;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MeiTuan1 {

    public static void main(String[] args) {
        //小顶
        PriorityQueue<Long> queue1 = new PriorityQueue<>();
        PriorityQueue<Long> queue2 = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            long num = sc.nextLong();
            if(queue1.size()<3)
                queue1.add(num);
            else {
                if(queue1.peek()<num){
                    queue1.poll();
                    queue1.add(num);
                }
            }
        }
        for(int i=0;i<n;i++){
            long num = sc.nextLong();
            if(queue2.size()<3)
                queue2.add(num);
            else {
                if(queue2.peek()<num){
                    queue2.poll();
                    queue2.add(num);
                }
            }
        }
        long sum1 =0;
        for(int i=0;i<3;i++){
            sum1 += queue1.poll();
        }
        long sum2 = 0;
        for(int i=0;i<3;i++){
            sum2 += queue2.poll();
        }
        System.out.println(sum1>sum2?sum1:sum2);

    }

    //        for(int i=0;i<3;i++){
//            System.out.print(queue1.poll() + " ");
//        }
//        System.out.println();
//        for(int i=0;i<3;i++){
//            System.out.print(queue2.poll() + " ");
//        }
//        System.out.println();
}
