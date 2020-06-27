package com.jp.LeetCode.question;


import java.util.Arrays;

//数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
//每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
//您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。

//f(i)表示从i出发需要花费多少体力值
//f(i)=cost[i]+min(f(i+1),f(i+2))
public class Q746_MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==1)
            return cost[0];
        else {
            int[] memo = new int[cost.length];
            Arrays.fill(memo,-1);
            return Math.min(dp(cost, 0,memo), dp(cost, 1,memo));
        }
    }

    public int dp(int[] cost,int i,int[] memo){
        if(i>=cost.length)
            return 0;
        if(memo[i]!=-1){
            return memo[i];
        }else {
            int result = cost[i]+Math.min(dp(cost,i+1,memo),dp(cost,i+2,memo));
            memo[i] = result;
            return result;
        }
    }

    public void test(int[] cost,int expected){
        System.out.println(minCostClimbingStairs(cost)==expected);
    }

    public static void main(String[] args) {
        Q746_MinCostClimbingStairs q746_minCostClimbingStairs = new Q746_MinCostClimbingStairs();
        q746_minCostClimbingStairs.test(new int[]{10, 15, 20},15);
        q746_minCostClimbingStairs.test(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1},6);
    }
}
