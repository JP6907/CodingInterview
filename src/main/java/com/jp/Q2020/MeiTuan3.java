package com.jp.Q2020;

import java.util.Arrays;
import java.util.Scanner;

public class MeiTuan3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n个任务
        int k = sc.nextInt();  //k个子任务
        long m = sc.nextLong();
        int p = sc.nextInt();
        int q = sc.nextInt();
        long[] times = new long[k];
        for(int i=0;i<k;i++)
            times[i] = sc.nextLong();
        Arrays.sort(times);
        int sum = 0;
        //不计额外分数
        for(int i=0;i<k;i++){
            if(m>n*times[i]){
                m -= (n*times[i]);
                sum += p*n;
            }else {
                long left = m/times[i];
                sum += (left*p);
            }
        }
        System.out.println(sum);

    }
}
