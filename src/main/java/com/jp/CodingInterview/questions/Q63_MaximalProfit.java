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

    static void Test(int[] numbers,int expected){
        System.out.println(MaxDiff(numbers)==expected);
        System.out.println(maxProfit(numbers)==expected);
    }

    public static void main(String[] args){
        Test(new int[]{4, 1, 3, 2, 5},4);
        Test(new int[]{1, 2, 4, 7, 11, 16 },15);
        Test(new int[]{16, 11, 7, 4, 2, 1},-1);
        Test(new int[]{16, 16, 16, 16, 16},0);
        Test(new int[]{9, 11, 5, 7, 16, 1, 4, 2 },11);
    }

    public static int maxProfit(int[] prices) {
        //dp[i][0]:第i天，没有持有股票的利润
        //dp[i][1]:第i天，持有股票的利润
        //只能买卖一次股票，则dp[i][1]=-price[i]
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1;i<n;i++){
            //如果股票价格一直下跌，则dp[i][0]会一直保持为0，即没有进行买卖
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(-prices[i], dp[i-1][1]);
        }
        return dp[n-1][0];
    }

}
