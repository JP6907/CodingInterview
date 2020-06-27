package com.jp.Q2020;

//看房子

import java.util.Scanner;

//对于每个位置，需要知道左边和右边分别能看到多少房子
//left[i]表示i位置往左边能看到的房子数量
//  left[i] = max(left[k])+1  k<i && a[i]>=a[k]，k往前面遍历的时候遇到大于a[i]的就停止
//  left[i] = 0 , if a[i]<a[i-1]
//right[i]表示i位置往右边能看到的房子数量
//  right[i] = max(right[k])+1 ,k>i&&a[i]>=a[k]，k往后面遍历的时候遇到大于a[i]的就停止
//  right[i] = 0 if a[i]<a[i+1]
//result[i] = left[i]+right[i]
public class ByteDance3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int j=0;j<n;j++)
                a[j] = sc.nextInt();
            int[] left = new int[n];
            int[] right = new int[n];
            //int[] result = new int[n];
            for(int j=1;j<n;j++){
                if(a[j]>=a[j-1]){
                    int max = 0;
                    for(int k=j-1;k>=0&&a[j]>=a[k];k--){
                        max = Math.max(max,left[k]);
                        left[j] = max + (j-k);
                    }
                }else {
                    left[j] = 0;
                }
            }
            for(int j=n-2;j>=0;j--){
                if(a[j]>=a[j+1]){
                    int max = 0;
                    for(int k=j+1;k<n&&a[j]>=a[k];k++){
                        max = Math.max(max,right[k]);
                        right[j] = max+(k-j);
                    }
                }else {
                    right[j] = 0;
                }
            }
            for(int j=0;j<n;j++) {
                System.out.print(left[j] + right[j] + " ");
                //result[j] = left[j] + right[j];
            }
            System.out.println();
        }
    }
}
