package com.jp.Q2020;

import java.util.Scanner;

public class Tencent {

    //输入
//    4
//    10 1
//    10 2
//    10 3
//    10 4
    //输出
    //1
    //2
    //5
    //-1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        for(int i=0;i<Q;i++){
            int x = sc.nextInt();
            int k = sc.nextInt();
            int level = getLevel(x);
            if(k>=level){
                System.out.println(-1);
            }else {
                int diff = level-k;
                x /= Math.pow(2,diff);
//                while (level!=k){
//                    x /= 2;
//                    level--;
//                }
                System.out.println(x);
            }

        }
    }

    //根据编号求层次
    //第k层：2^(k-1)   2^k-1
    public static int getLevel(int number){
        //Math.log :  以e为底部的对数
        int level = (int)(Math.log(number)/Math.log(2)+1);
//        int level = 1;
//        while (!(number>=Math.pow(2,level-1)&&number<=Math.pow(2,level)-1)){
//            level++;
//        }
        return level;
    }
}
