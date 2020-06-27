package com.jp.Q2020;

import java.util.Scanner;

public class NiukeWang {

    public static void Q1(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] nums = new long[N];
        long max = Integer.MIN_VALUE;
        for(int i=0;i<N;i++){
            nums[i] = sc.nextLong();
            max = Math.max(max,nums[i]);
        }
        boolean flag = true;
        for(int i=0;i<N;i++){
            while (nums[i]<max)
                nums[i]*=2;
            if(nums[i]!=max){
                flag = false;
                break;
            }
        }
        if(!flag)
            System.out.println("NO");
        else
            System.out.println("YES");
    }

}
