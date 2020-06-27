package com.jp.Q2020;

import java.util.Arrays;
import java.util.Scanner;

//优惠券
//输入
//3 4
//50 100 200
//99 199 200 300
//输出
//248
public class ByteDance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<m;i++){
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        //上一个商品使用的优惠券
        int index = -1;
        int cost = 0;
        //每件商品
        for(int i=0;i<m;i++){
            while (index+1<n&&a[index+1]<=b[i])
                index++;
            cost += (b[i]-a[index]);
        }
        System.out.println(cost);
    }
}
