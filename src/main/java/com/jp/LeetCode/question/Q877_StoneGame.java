package com.jp.LeetCode.question;

/**
 * 石子游戏
 * @author zjp
 * @createTime 2020/6/27 12:10
 **/
public class Q877_StoneGame {

    //由于每次只能从左右两次拿石子，所以可以用一个区间(i,j)表示当前剩下的石子范围
    //状态表示：
    //  dp[i][j][0]:表示在(i,j)中先手能够拿到的最大分数
    //  dp[i][j][1]:表示在(i,j)中后手能够拿到的最大分数
    //状态转移：
    //  先手dp[i][j][0]：
    //      选择左边：left = piles[i]+dp[i+1][j][1]
    //      选择右边：right = piles[j]+dp[i][j-1][1]
    //  如果left > right：先手选左边，则后手 dp[i][j][1] = dp[i+1][j][0]
    //  else：            先手选右边，则后手 dp[i][j][1] = dp[i][j-1][0]
    //初始状态：
    //  只有一堆石子，(i,i)， 先手得分为piles[i]，后手为0
    public static boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[n][n][2];
        for(int i=0;i<n;i++){
            dp[i][i][0] = piles[i];
            dp[i][i][1] = 0;
        }
        for(int k=1;k<n;k++){
            for(int i=0;i<n-k;i++){
                //(i,i+k)
                int left = piles[i] + dp[i+1][i+k][1];
                int right = piles[i+k] + dp[i][i+k-1][1];
                if(left > right){
                    dp[i][i+k][0] = left;
                    dp[i][i+k][1] = dp[i+1][i+k][0];
                }else {
                    dp[i][i+k][0] = right;
                    dp[i][i+k][1] = dp[i][i+k-1][0];
                }
            }
        }
        return dp[0][n-1][0] > dp[0][n-1][1];
    }

    public static void test(int[] piles, boolean expected){
        System.out.println(stoneGame(piles)==expected);
    }

    public static void main(String[] args) {
        test(new int[]{5,3,4,5},true);
    }

}
