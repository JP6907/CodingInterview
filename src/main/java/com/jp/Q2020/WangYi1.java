package com.jp.Q2020;

import java.util.Scanner;

public class WangYi1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //城市个数
        int m = sc.nextInt(); //操作个数
        int s = sc.nextInt(); //所在城市编号
        int[] flag = new int[n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == 0) {
                if (y != s) {
                    if(flag[y-1]!=-1) {
                        flag[y - 1] = -1;
                        count++;
                    }
                } else {
                    System.out.println(i + 1);
                    return;
                }
            } else {
                if (x == s) {
                    if(flag[y-1]!=-1){
                        flag[y - 1] = -1;
                        count++;
                    }
                } else if (y == s) {
                    if(flag[x-1]!=-1) {
                        flag[x - 1] = -1;
                        count++;
                    }
                }
            }
            if (count == n-1) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(0);

    }
}
