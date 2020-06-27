package com.jp.Q2020;

import java.util.Scanner;

public class HuwWei3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] invokeCount = new int[n];
        for(int i=0;i<n;i++){
            invokeCount[i] = sc.nextInt();
        }
        boolean[][] invokeMatrix = new boolean[n][n];
        int[] stackDepth = new int[n];
        for(int i=0;i<n;i++){
            int functionIndex = sc.nextInt();
            if(functionIndex>n){
                System.out.println("NA");
                return;
            }
            int depth = sc.nextInt();
            stackDepth[functionIndex-1] = depth;
            for(int j=0;j<invokeCount[functionIndex-1];j++){
                int invoke = sc.nextInt();
                if(invoke>n){
                    System.out.println("NA");
                    return;
                }
                invokeMatrix[functionIndex-1][invoke-1] = true;
            }
        }
        //寻找入口：invokeCount不为0
        for(int i=0;i<n;i++){
            if(invokeCount[i]!=0){
                boolean[] visited = new boolean[n];
                boolean result = invokeLink(invokeMatrix,stackDepth,visited,i,0,n);
                if(!result){
                    System.out.println("R");
                    return;
                }

            }
        }
        System.out.println(max);
    }

    static int max = Integer.MIN_VALUE;

    public static boolean invokeLink(boolean[][] invokeMatrix,int[] stackDepth,boolean[] visited,int curr,int currDepth,int n){
        if(visited[curr])
            return false;
        visited[curr] = true;
        currDepth += stackDepth[curr];
        int count = 0;
        for(int i=0;i<n;i++){
            if(invokeMatrix[curr][i]){
                if(curr==i)
                    return false;
                boolean result = invokeLink(invokeMatrix,stackDepth,visited,i,currDepth,n);
                if(!result)
                    return false;
                count++;
            }
        }
        visited[curr] = false;
        if(count==0)
            max = Math.max(max,currDepth);
        return true;
    }
}
