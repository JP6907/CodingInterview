package com.jp.Q2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baidu3 {

    static int currentLongest = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] weight = new int[N];
        for(int i=0;i<N;i++)
            weight[i] = sc.nextInt();
        List<List<Integer>> edges = new ArrayList<>();
        for(int i=0;i<N;i++){
            edges.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++){
            int node1 = sc.nextInt()-1;
            int node2 = sc.nextInt()-1;
            edges.get(node1).add(node2);
            edges.get(node2).add(node1);
        }
        int longest = Integer.MIN_VALUE;
        for(int i=0;i<N;i++) {
            currentLongest = Integer.MIN_VALUE;
            List<Integer> path = new ArrayList<>();
            path.add(i);
            longestPath(path,i,weight,edges);
            longest = Math.max(longest,currentLongest);
        }
        System.out.println(longest);
    }

    public static void longestPath(List<Integer> path,int current,int[] weight,List<List<Integer>> edges){
        List<Integer> edge = edges.get(current);
        boolean hasPath = false;
        for(Integer node : edge){
            if(!path.contains(node)&&weight[node]>weight[current]){
                hasPath = true;
                path.add(node);
                longestPath(path,node,weight,edges);
                path.remove(path.size()-1);
            }
        }
        if(!hasPath){
            currentLongest = Math.max(currentLongest,path.size());
        }
    }
}
