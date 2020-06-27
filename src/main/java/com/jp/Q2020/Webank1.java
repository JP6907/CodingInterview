package com.jp.Q2020;

import java.util.Scanner;

public class Webank1 {
    //7 5 10 100   20
    //2 2 10 10    0
    //3 1 10 10    20
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //人数
        int m = sc.nextInt(); //准备礼物数量
        int a = sc.nextInt(); //红包
        int b = sc.nextInt(); //礼物价格
        if(m>0&&m%n==0){
            System.out.println(0);
        }else {
            //方法1：礼物轮询分完，剩下的再使用这两种操作
            int diff = (n - m%n); //还需多少份礼物
            int min = Math.min(a,b);
            int result1 = diff*min;

            //方法2：先让一部分人离开
            if(m>n){
                //求小于n，且能让m整除的最大的数
                int n1 = n-1;
                while (n1>0&&m%n1!=0)
                    n1--;
                int result2 = 0;
                int leave = n-n1;
                result2 += leave*a;  //先离开的人数，剩下的平分礼物
                System.out.println(Math.min(result1,result2));
            }else {
                System.out.println(result1);
            }

        }

    }
}
