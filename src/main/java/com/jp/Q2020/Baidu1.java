package com.jp.Q2020;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Baidu1 {

    static Map<String,Long> gcdMemo = new HashMap<>();
    static Map<String,Long> lcmMemo = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long N = sc.nextLong();

        Long max = Long.MIN_VALUE;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(gcd(i,j)==1){
                    max = Math.max(max,lcm(i,j)-gcd(i,j));
                }
            }
        }
        System.out.println(max);
    }

    public static long gcd(long a,long b){
        if(a<b){
            long temp = a;
            a = b;
            b = temp;
        }
        String key = a+"_"+b;
        if(gcdMemo.containsKey(key))
            return gcdMemo.get(key);
        //a为大者
        long remainder = a%b;
        while (remainder!=0){
            a = b;
            b = remainder;
            remainder = a%b;
        }
        gcdMemo.put(key,b);
        return b;
    }

    public static long lcm(long a,long b){
        if(a<b){
            long temp = a;
            a = b;
            b = temp;
        }
        String key = a+"_"+b;
        if(lcmMemo.containsKey(key))
            return lcmMemo.get(key);
        long gcdAB = gcd(a,b);
        long result = a*b/gcdAB;
        lcmMemo.put(key,result);
        return result;
    }
}
