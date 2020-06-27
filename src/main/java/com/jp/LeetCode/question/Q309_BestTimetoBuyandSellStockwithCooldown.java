package com.jp.LeetCode.question;

/**
 * @author zjp
 * @createTime 2020/6/27 16:35
 **/
public class Q309_BestTimetoBuyandSellStockwithCooldown {

    //包含冷冻期
    //你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    //卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
    //如果在冷冻期,则从第i-2个状态转移
    //dp[][][]
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        int dp_pre_0 = 0;
        for(int i=1;i<n;i++){
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0-prices[i]); //不能根据dp[i-1][0]买入
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }

    public static void test(int[] prices, int expected){
        System.out.println(maxProfit(prices)==expected);
    }

    public static void main(String[] args) {
        test(new int[]{1,2,3,0,2}, 3);
    }


}
