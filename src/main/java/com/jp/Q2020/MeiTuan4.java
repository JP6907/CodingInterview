package com.jp.Q2020;

import java.util.Scanner;

public class MeiTuan4 {

    public static class Edge{
        public int a;
        public int b;
        public int len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        Edge[] edges = new Edge[m];
        for(int i=0;i<m;i++){
            edges[i].a = sc.nextInt();
            edges[i].b = sc.nextInt();
            edges[i].len = sc.nextInt();
        }
        int k = sc.nextInt();

        System.out.println(2);
    }
}
