package com.jp.Q2020;

import java.util.Arrays;
import java.util.Scanner;

public class Baidu2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for(int i=0;i<n;i++)
            a[i] = sc.nextLong();
        Arrays.sort(a);
        int count = 0;
        while (a[n-1]>=n){
            long diff = a[n-1]-a[n-2];
            long currentCount = 0;
            currentCount += (diff/n+1);
            count += currentCount;
            a[n-1] -= currentCount*n;
            for(int i=0;i<n-1;i++)
                a[i] -= currentCount;

            long temp = a[n-1];
            for(int i=n-2;i>=0;i--){
                if(temp<a[i])
                    a[i+1] = a[i];
                else {
                    a[i+1] = temp;
                    break;
                }
            }

        }
        System.out.println(count);
    }
}
