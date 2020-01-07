package com.jp.question;

// 面试题56（二）：数组中唯一只出现一次的数字
// 题目：在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请
// 找出那个吃出现一次的数字

public class Q56_02_NumberAppearingOnce {

    static int FindNumberAppearingOnce(int[] data){
        int[] bitSum = new int[Integer.SIZE];
        for(int d : data){
            int bitMask = 1;
            for(int i=0;i<Integer.SIZE;i++){
                bitSum[Integer.SIZE-i-1] += d&bitMask;
                bitMask = bitMask<<1;
            }
        }
        int result = 0;
        for(int i=0;i<Integer.SIZE;i++){
            result = result << 1;
            result += bitSum[i]%3;
        }
        return result;
    }

    public static void main(String[] args){
        int[] data = {1,2,3,4,5,1,2,3,5,1,2,3,5};
        System.out.println(FindNumberAppearingOnce(data));
    }
}
