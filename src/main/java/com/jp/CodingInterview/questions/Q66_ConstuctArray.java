package com.jp.CodingInterview.questions;

// 面试题66：构建乘积数组
// 题目：给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，其
// 中B中的元素B[i] =A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

// C[i]=A[0]*A[1]*A[2]...A[i-1]
// C[i]=C[i-1]*A[i-1]
// D[i]=A[i+1]*..........A[n-1]
// D[i]=D[[i+1]*A[i+1]
// B[i]=C[i]*D[i]

import java.util.Arrays;

public class Q66_ConstuctArray {


    static void multiply(int[] A,int[] B){
        int lenA = A.length;
        int lenB = B.length;
        if(lenA==lenB){
            B[0] = 1;
            for(int i=1;i<lenA;i++){
                B[i] = B[i-1]*A[i-1];
            }
            int temp = 1;
            for(int i=lenA-2;i>=0;i--){
                temp *= A[i+1];
                B[i] *= temp;
            }
        }
    }

    static boolean Test(int[] A,int[] expected){
        int[] B = new int[A.length];
        multiply(A,B);
        return Arrays.equals(B,expected);
    }

    public static void main(String[] args){
        System.out.println(Test(new int[]{1, 2, 3, 4, 5 },new int[]{ 120, 60, 40, 30, 24}));
        System.out.println(Test(new int[]{1, 2, 0, 4, 5 },new int[]{ 0, 0, 40, 0, 0 }));
        System.out.println(Test(new int[]{1, -2, 3, -4, 5 },new int[]{ 120, -60, 40, -30, 24 }));
    }
}
