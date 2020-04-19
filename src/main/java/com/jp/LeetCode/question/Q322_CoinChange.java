package com.jp.LeetCode.question;

//You are given coins of different denominations and a total amount of money amount.
// Write a function to compute the fewest number of coins that you need to make up that amount.
// If that amount of money cannot be made up by any combination of the coins, return -1.
//
//Example 1:
//
//Input: coins = [1, 2, 5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
//Example 2:
//
//Input: coins = [2], amount = 3
//Output: -1
//Note:
//You may assume that you have an infinite number of each kind of coin.

//https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E8%AF%A6%E8%A7%A3%E8%BF%9B%E9%98%B6.md
//兑换零钱问题，硬币数量无限，用最少的硬币组合成目标值
//dp[n] = Min(dp[n-coin]+1) coin in coins
public class Q322_CoinChange {

    public static int coinChange2(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        for(int i=0;i<memo.length;i++){
            memo[i] = amount+1;
        }
        memo[0]=0;
        //目标金额为i
        for(int i=0;i<memo.length;i++){
            for (int coin : coins){
                if(i-coin<0)
                    continue;
                memo[i] = Math.min(memo[i],memo[i-coin]+1);
            }
        }
        return memo[amount]==amount+1?-1:memo[amount];
    }

    public static int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        for (int i = 0; i < memo.length; i++)
            memo[i] = -2;
        return coinChangeCore(coins, amount, memo);
    }

    public static int coinChangeCore(int[] coins, int amount, int[] memo) {
        if (amount == 0)
            return 0;
        else if (amount < 0)
            return -1;
        if (amount < memo.length && memo[amount] != -2)
            return memo[amount];
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = coinChangeCore(coins, amount - coin, memo);
            if (subProblem == -1)
                continue;
            result = Math.min(result, subProblem + 1);
        }
        if (result == Integer.MAX_VALUE)
            memo[amount] = -1;
        else
            memo[amount] = result;
        return memo[amount];
    }

    public static void test(int[] coins, int amount, int expeccted) {
        System.out.println(coinChange(coins,amount)==expeccted);
        System.out.println(coinChange2(coins,amount)==expeccted);
    }

    public static void main(String[] args) {
        test(new int[]{1,2,5},11,3);
        test(new int[]{2},3,-1);
    }

}