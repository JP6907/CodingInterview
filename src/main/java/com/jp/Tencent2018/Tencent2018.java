package com.jp.Tencent2018;


import java.util.Scanner;

public class Tencent2018 {

    // n/(2*m)  组
    // 每组的和为 M^2
    // n/(2*m)*m^2 =
    // 测试：8 2 ->8

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int sum = (N/(2*M))*M*M;
        int left = N%(2*M);  //剩余的数字个数
        int num = N-left+1;
        int flag = -1;
        int count = 0;
        while (num<=N){
            sum += (flag*num);
            if(++count==M)
                flag = -flag;
            num++;
        }
        System.out.println(sum);
    }
}
