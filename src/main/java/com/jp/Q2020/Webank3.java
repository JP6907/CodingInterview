package com.jp.Q2020;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Webank3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] card = new int[n][2];
        for(int i=0;i<n;i++){
            card[i][0] = sc.nextInt();
            card[i][1] = sc.nextInt();
        }
        //抽卡次数的排在前面，次数为0的按照钱数降序排列
        Arrays.sort(card, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o2[0] - o1[0];
                }else {
                    return o2[1] - o1[1];
                }
            }
        });
        int sum = 0;
        int count = 1; //抽卡次数
        int index = 0;
        while (count>0&&index<n){
            count--;
            sum += card[index][0];
            count += card[index][1];
            index++;
        }
        System.out.println(sum);

    }
}
