package com.jp.CodingInterview.questions;

// 面试题17：打印1到最大的n位数
// 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
// 打印出1、2、3一直到最大的3位数即999。
public class Q17_Print1ToMaxOfNDigits {

    public static void print1ToMaxOfN(int n){
        StringBuffer sb = new StringBuffer(n);
        for(int i=0;i<n;i++)
            sb.append('0');
        print1ToMaxOfNRecursively(sb,n,0);
    }

    public static void print1ToMaxOfNRecursively(StringBuffer num,int n,int index){
        if(index==n){
            printNum(num.toString());
            System.out.println();
            return;
        }else{
            for(int i=0;i<10;i++){
                num.setCharAt(index,(char)(i+'0'));
                print1ToMaxOfNRecursively(num,n,index+1);
            }
        }
    }

    //最前面的0不打印
    public static void printNum(String num){
        boolean isBeginning0 = true;
        for(int i=0;i<num.length();i++){
            if(isBeginning0&&num.charAt(i)!='0')
                isBeginning0 = false;
            if(!isBeginning0){
                System.out.print(num.charAt(i));
            }
        }
        if (isBeginning0){//所有数字都是0
            System.out.print("0");
        }
    }

    public static void main(String[] args){
        print1ToMaxOfN(4);
    }
}
