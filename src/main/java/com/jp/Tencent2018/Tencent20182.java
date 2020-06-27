package com.jp.Tencent2018;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Tencent20182 {

    //3
    //2 7 4
    //5
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] numbers = new Integer[N];
        for(int i=0;i<N;i++)
            numbers[i] = sc.nextInt();
        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int sum = 0;
        int flag = 1;
        for(int i=0;i<N;i++){
            sum += (flag*numbers[i]);
            flag = 0-flag;
        }
        System.out.println(sum);
    }
}
