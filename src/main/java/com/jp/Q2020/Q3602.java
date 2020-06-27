package com.jp.Q2020;

import java.util.Scanner;


//两个问题
//1.递归遍历，使用dp记忆化！
//2.输出结果保留4位小数！
//深度遍历模拟所有抽取情况
public class Q3602 {
    // 2 3  0.6
    // 1 3  0.5
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double[][] dp = new double[n+1][m+1]; //记忆化
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++)
                dp[i][j] = -1;
        }
        double prob = helper(n,m,dp);
        System.out.format("%.4f",prob);
    }

    public static double helper(int n,int m,double[][] dp){
        if(dp[n][m]!=-1)
            return dp[n][m];
        if(n<=0)
            return 0.0;
        if(m<=0)
            return 1.0;
        //A中奖概率=
        // A抽中的概率 + B不抽中，A在下一轮抽中的概率
        double prob = 0.0;
        //A抽
        //A中奖
        prob += (double) n/((double) (n+m));
        //A不中奖 n,m-1  B抽
        double aNot = (double)m/((double)(m+n));
        //B中奖
        //B不中奖 n,m-2
        double bNot = (double) (m - 1) / ((double) (n + m - 1));
        if(m-2>0) {
            //B 丢弃 中奖票 n-1,m-2
            double discardIn = (double) n / ((double) (m + n - 2));
            prob += aNot * bNot * discardIn * helper(n - 1, m - 2,dp);
            //B 丢弃 不中奖票 n,m-3
            double discardNotIn = (double) (m - 2) / ((double) (m + n - 2));
            prob += aNot * bNot * discardNotIn * helper(n, m - 3,dp);
        }else{
            if(n>1)
                prob += aNot*bNot;
        }
        dp[n][m] = prob;
        return prob;
    }
}
