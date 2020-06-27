package com.jp.Q2020;

import java.util.Scanner;

public class SanQi1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int N = sc.nextInt();//正整数个数
            int M = sc.nextInt(); //操作数
            int newParentIndex = N+1;
            int[] parents = new int[N+1];
            int[] size = new int[N+1];
            for(int k=1;k<=N;k++) {
                parents[k] = k;
                size[k] = 1;
            }
            for(int j=0;j<M;j++){
                int op = sc.nextInt();
                if(op==1){
                    //合并
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    int parentX = parents[x];
                    int parentY = parents[y];
                    if(parentX!=parentY) {
                        int parent = Math.min(parentX, parentX);
                        int newSize = size[x]+size[y];
                        for(int k=1;k<=N;k++){
                            if(parents[k]==parentX||parents[k]==parentY){
                                parents[k] = parent;
                                size[k] = newSize;
                            }
                        }
                    }
                }else if(op==2){
                    //独立
                    int x = sc.nextInt();
                    if(size[x]!=1){
                        int oldParent = parents[x];
                        parents[x] = newParentIndex++;
                        size[x] = 1;
                        for(int k=1;k<=N;k++){
                            if(parents[k]==oldParent&&k!=x)
                                size[k] -=1;
                        }
                    }
                }else {
                    //输出当前集合中的整数数量
                    int x = sc.nextInt();
                    System.out.println(size[x]);
                }
            }
        }
    }

}

//输入：
//3
//3 7
//3 1
//1 1 2
//3 1
//1 2 3
//3 1
//2 1
//3 1
//3 5
//1 2 3
//3 1
//2 3
//1 2 1
//3 1
//3 5
//1 2 3
//1 2 1
//3 1
//2 3
//3 1
//输出：
//1
//2
//3
//1
//1
//2
//3
//2