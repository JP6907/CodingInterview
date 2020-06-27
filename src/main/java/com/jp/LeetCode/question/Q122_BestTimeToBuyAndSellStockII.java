package com.jp.LeetCode.question;

/**
 * @author zjp
 * @createTime 2020/6/21 11:12
 **/
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//
//设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
//注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
public class Q122_BestTimeToBuyAndSellStockII {

    //f(n)(0) 表示前n天交易，当前未持有股票
    //f(n)(1) 表示前n天交易，当前持有股票
    //f(n)(0) = max{前一天未持有，前一天持有+今天卖出}
    //        = max{f(n-1)(0),f(n-1)(1)+price[n]}
    //f(n)(1) = max{前一天未持有+今天买入，前一天持有}
    //        = max{f(n-1)(0)-price[n],f(n-1)(1)}
    //初始状态：
    //f(0)(0)=0
    //f(0)(1)=price[0]
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for(int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }
        return dp[n-1][0];
    }

    public static int maxProfit11(int[] prices) {
        //f(n)(0) = max{f(n-1)(0),f(n-1)(1)+prices[n]}
        //f(n)(1) = max{f(n-1)(0)-prices[n],f(n-1)(1)}
        int n = prices.length;
        int[][] f = new int[n][2];
        f[0][1] = -prices[0];
        f[0][0] = 0;
        for(int i=1;i<n;i++){
            f[i][0] = Math.max(f[i-1][0],f[i-1][1]+prices[i]);
            f[i][1] = Math.max(f[i-1][0]-prices[i],f[i-1][1]);
        }
        return f[n-1][0];
    }

    //优化
    //贪心
    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        int result = 0;
        for(int i=1;i<n;i++){
            if(prices[i]>prices[i-1])
                result += (prices[i]-prices[i-1]);
        }
        return result;
    }

    public static void test(int[] prices,int expected){
        System.out.println(maxProfit(prices)==expected);
        System.out.println(maxProfit2(prices)==expected);
    }

    public static void main(String[] args) {
        test(new int[]{7,1,5,3,6,4},7);
        test(new int[]{1,2,3,4,5},4);
        test(new int[]{7,6,4,3,1},0);
    }

}
