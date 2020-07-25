package com.jp.LeetCode.ByteDance;

/**
 * @author zjp
 * @createTime 2020/7/25 21:05
 **/
public class Q_maximalSquare {

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if(rows == 0){
            return 0;
        }
        int cols = matrix[0].length;
        if(cols == 0){
            return 0;
        }
        int[][] dp = new int[rows][cols];
        int max = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j] == '1'){
                    if(i==0 || j==0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }

}
