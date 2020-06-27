package com.jp.LeetCode.question;

/**
 * @author zjp
 * @createTime 2020/6/27 16:54
 **/
public class Q714_BestTimetoBuyandSellStockwithTransactionFee {

    //无限次交易
    //每次交易需要手续费
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        for(int i=1;i<n;i++){
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1+prices[i]-fee);
            dp_i_1 = Math.max(dp_i_1, temp-prices[i]);
        }
        return dp_i_0;
    }

    public static void test(int[] prices, int fee, int expected){
        System.out.println(maxProfit(prices, fee)==expected);
    }

    public static void main(String[] args) {
        test(new int[]{1, 3, 2, 8, 4, 9}, 2, 8);
    }

}
