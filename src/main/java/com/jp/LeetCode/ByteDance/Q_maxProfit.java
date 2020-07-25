package com.jp.LeetCode.ByteDance;

/**
 * @author zjp
 * @createTime 2020/7/25 19:40
 **/
public class Q_maxProfit {

    // 买卖股票的最佳时机 II
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2){
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < n; i++){
            if(prices[i] - min > maxProfit){
                maxProfit = prices[i] - min;
            }
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }

    public static void test(int[] prices, int expected){
        System.out.println(maxProfit(prices) == expected);
    }

    public static void main(String[] args) {
        test(new int[]{7,1,5,3,6,4}, 5);
        test(new int[]{7,6,4,3,1}, 0);

        test2(new int[]{7,1,5,3,6,4}, 7);
        test2(new int[]{1,2,3,4,5}, 4);
        test2(new int[]{7,6,4,3,1}, 0);
    }


    // 买卖股票的最佳时机 II
    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        if(n < 2){
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }

    public static void test2(int[] prices, int expected){
        System.out.println(maxProfit2(prices) == expected);
    }

}
