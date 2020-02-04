package com.jp.CodingInterview;

// 15：二进制中1的个数
// 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
// 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
public class Q15_NumberOf1InBinary {

//    public static int NumberOf1(int n){
//        int temp;
//        int count=0;
//        for(int i=0;i<Integer.SIZE;i++){
//            temp = n>>i;
//            if((temp&0x01)==1)
//                count++;
//        }
//        return count;
//    }

    public static int NumberOf1(int n){
        int count = 0;
        int flag = 1;
        while(flag!=0){
            if((n&flag)==flag)
                count++;
            flag = flag<<1;
        }
        return count;
    }

    public static void Test(int n,int expected){
        System.out.println(NumberOf1(n)==expected);
    }

    public static void main(String[] args){
        Test(0, 0);
        Test(9,2);
        Test(1, 1);
        Test(10, 2);
        Test(0x7FFFFFFF, 31);
        Test(0xFFFFFFFF, 32);
        Test(0x80000000, 1);
    }
}
