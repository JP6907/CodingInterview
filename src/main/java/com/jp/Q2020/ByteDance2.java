package com.jp.Q2020;

//折木棍
//在你的面前从左到右摆放着n根长短不一的木棍，你每次可以折断一根木棍，
// 并将折断后得到的两根木棍一左一右放在原来的位置（即若原木棍有左邻居，
// 则两根新木棍必须放在左邻居的右边，若原木棍有右邻居，新木棍必须放在右邻居的左边，所有木棍保持左右排列）。
// 折断后的两根木棍的长度必须为整数，且它们之和等于折断前的木棍长度。
// 你希望最终从左到右的木棍长度单调不减，那么你需要折断多少次呢？

import java.util.Scanner;
import java.util.Stack;

//输入
//5
//3 5 13 9 12
//输出
//1
public class ByteDance2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(int i=n-1;i>=0;i--){
            if(!stack.empty()&&stack.peek()<a[i]){
                int t = (a[i]-1)/stack.peek();
                count += t;
                stack.push(a[i]/(t+1));
            }else{
                stack.push(a[i]);
            }
        }
        System.out.println(count);
    }
}
