package com.jp.Q2020;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


//AC100
public class XieCheng1 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
//    static int calcMinStaff() {
//
//
//    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] times = new int[n][2];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            String[] fields = sc.next().split(",");
            times[i][0] = Integer.parseInt(fields[0]);
            times[i][1] = Integer.parseInt(fields[1]);
            min = Math.min(min,times[i][0]);
            max = Math.max(max,times[i][1]);
        }
        int[] count = new int[max-min+1];
        for(int i=0;i<n;i++){
            for(int j=times[i][0];j<times[i][1];j++)
                count[j-min]++;
        }
        int result = Integer.MIN_VALUE;
        for(int i=0;i<max-min+1;i++){
            result = Math.max(result,count[i]);
        }
        System.out.println(result);

    }
}

