package com.jp.Q2020;

import java.util.Scanner;

public class MeiTuan0423 {

    public static void main(String[] args) {
        //question3();
        question5();
    }

    public static void question1(){
        Scanner sc = new Scanner(System.in);

    }

    public static void question2(){
        Scanner sc = new Scanner(System.in);

    }

    //输入：
    //4
    //1 2 1 2
    //输出：
    //1
    //4
    //2
    //3
    public static void question3(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] A = new long[n];
        for(int i=0;i<n;i++){
            A[i] = sc.nextLong();
        }
        boolean[] isOut = new boolean[n];
        int[] order = new int[n];//排名
        //n轮
        for(int roundNum=0;roundNum<n;roundNum++){
            //报数
            long count=0;
            long maxCount = A[roundNum];
            int index=0;
            //maxCount的人出局
            while (count<maxCount){
                count++;
                index = (index+1)%n;
                while (isOut[index]){
                    index = (index+1)%n;
                }
            }
            isOut[index] = true;
            order[index] = n-roundNum;
        }
        //依次输出1-n选手的排行
        for(int i=0;i<n;i++){
            System.out.println(order[i]);
        }
    }

    //4
    //3 5 6 1

    //-1 -1 1 1
    public static void question5(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            if(result[i]==0) {
                boolean flag = true;
                for (int j = 0; j < n; j++) {
                    if (i != j && (a[i] & a[j]) == 0) {
                        result[i] = -1;
                        result[j] = -1;

                    }
                }
                if (result[i] == 0)
                    result[i] = 1;
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
