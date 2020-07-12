package com.jp.LeetCode.question;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 计算区间 [2, n) 中有几个素数
 * @author zjp
 * @createTime 2020/7/11 15:08
 **/
public class CountPrimes {

    //最暴力的写法，会出现大量的重复计算
    public static int countPrimes(int n){
        int count = 0;
        for(int i=2;i<n;i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }

    //记忆化削减冗余计算
    public static int countPrimes2(int n){
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for(int i=2;i<n;i++){
            if(isPrime[i]){
                for(int j=2*i;j<n;j+=i){
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for(int i=2;i<n;i++){
            if(isPrime[i]){
                count++;
            }
        }
        return count;
    }


    public static boolean isPrime(int n){
        for(int i=2;i*i<=n;i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public static void test(int n){
        System.out.format("countPrimes(%d): %d\n",n, countPrimes(n));
        System.out.format("countPrimes2(%d): %d\n",n, countPrimes2(n));
        System.out.println("======");
    }

    public static void main(String[] args) {
        for(int i=2;i<10;i++){
            test(i);
        }
    }

}
