package com.jp.Q2020;

import java.util.Arrays;
import java.util.Scanner;

public class PDD {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] C = new int[N];
        for(int i=0;i<N;i++){
            C[i] = sc.nextInt();
        }
        Arrays.sort(C);
        for(int i=0;i<M;i++){
            if(C[N-1]-C[0]<=1)
                break;
            C[N-1]--;
            C[0]++;
            insertSort(C,N-1);
            insertSort(C,0);
        }
        System.out.println(C[N-1]-C[0]);
    }


    public static void insertSort(int[] array,int index){
        if(index==0){
            int temp = array[index];
            int i = 1;
            for(;i<array.length&&array[i]<temp;i++){
                array[i-1] = array[i];
            }
            array[i-1] = temp;
        }else {
            int temp = array[index];
            int i = array.length-2;
            for(;i>=0&&array[i]>temp;i--){
                array[i+1] = array[i];
            }
            array[i+1] = temp;
        }
    }
}
