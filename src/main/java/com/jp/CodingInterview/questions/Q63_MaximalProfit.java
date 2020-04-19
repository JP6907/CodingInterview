package com.jp.CodingInterview.questions;

// 面试题63：股票的最大利润
// 题目：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖交易该股
// 票可能获得的利润是多少？例如一只股票在某些时间节点的价格为{9, 11, 8, 5,
// 7, 12, 16, 14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能
// 收获最大的利润11。

// 遍历数组
// diff(i):i与0~i中最小值的差值
// 遍历过程中记录 0~i 中的最小值
// 返回 diff 中的最大值

public class Q63_MaximalProfit {

    static int MaxDiff(int[] numbers){
        if(numbers.length<2)
            return 0;
        int min = numbers[0];
        int current = numbers[1];
        int maxDiff = current - min;
        for(int i=2;i<numbers.length;i++){
            if(numbers[i-1]<min)
                min = numbers[i-1];
            int currentDiff = numbers[i]-min;
            if(currentDiff>maxDiff)
                maxDiff = currentDiff;
        }
        return maxDiff;
    }

    static boolean Test(int[] numbers,int expected){
        return MaxDiff(numbers)==expected;
    }

    public static void main(String[] args){
        System.out.println(Test(new int[]{4, 1, 3, 2, 5},4));
        System.out.println(Test(new int[]{1, 2, 4, 7, 11, 16 },15));
        System.out.println(Test(new int[]{16, 11, 7, 4, 2, 1},-1));
        System.out.println(Test(new int[]{16, 16, 16, 16, 16},0));
        System.out.println(Test(new int[]{9, 11, 5, 7, 16, 1, 4, 2 },11));
    }

}
