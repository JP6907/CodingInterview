package com.jp.LeetCode.question;

import java.util.Arrays;
import java.util.concurrent.ConcurrentNavigableMap;

/**
 * @author zjp
 * @createTime 2020/7/12 10:05
 **/
public class Q174_CalculateMinimumHP {


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}};
        test(new int[][]{{0}}, 1);
        test(matrix, 7);
        test(new int[][]{{-3, 5}}, 4);
        test(new int[][]{{3,0,-3},{-3,-2,-2},{3,1,-3}}, 1);

    }

    public static void test(int[][] dungeon, int expected){
        System.out.format("%d  %d \n", calculateMinimumHP(dungeon), expected);
        System.out.println(calculateMinimumHP(dungeon) == expected);
        System.out.println("=-==");
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        if(rows <= 0){
            return -1;
        }
        int cols = dungeon[0].length;
        int left = 1, right = getMax(dungeon);
        int[][] flag = new int[rows][cols];
        while (left < right){
            clearFlag(flag);
            int mid = left + (right - left)/2;
            //if(canReach(dungeon, rows, cols, 0, 0, mid)){
            if(canReach2(dungeon, mid)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    public static void clearFlag(int[][] flag){
        int rows = flag.length;
        for(int i=0;i<rows;i++){
            Arrays.fill(flag[i], 0);
        }
    }


    //递归方式
    //递归方式不能记忆话
    //每个位置的来源位置不一样
    public static boolean canReach(int[][] dungeon, int rows, int cols, int row, int col, int initHealth){
        if(row < 0 || row >= rows || col < 0 || col >= cols){
            return false;
        }
        initHealth += dungeon[row][col];
        if (initHealth <= 0)
            return false;
        if (row == rows - 1 && col == cols - 1) {
            return initHealth >= 1;
        }
        boolean result = canReach(dungeon, rows, cols, row, col + 1, initHealth)
                || canReach(dungeon, rows, cols, row + 1, col, initHealth);

        return result;
    }


    //dp[i][j] 表示走到（i，j）的最大健康值
    // = dp[i+1][j] dp[i][j+1]
    public static boolean canReach2(int[][] dungenon, int initHealth){
        int rows = dungenon.length;
        int cols = dungenon[0].length;
        int[][] dp = new int[rows+1][cols+1];
        for(int i=0;i<rows;i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = initHealth + dungenon[0][0];
        if(dp[0][0] <= 0){
            return false;
        }
        for(int i=0;i<rows-1;i++){
            dp[i+1][0] = dp[i][0] + dungenon[i+1][0];
            if(dp[i+1][0] <= 0){
                dp[i+1][0] = Integer.MIN_VALUE;
                break;
            }
        }
        for(int i=0;i<cols-1;i++){
            dp[0][i+1] = dp[0][i] + dungenon[0][i+1];
            if(dp[0][i+1] <= 0){
                dp[0][i+1] = Integer.MIN_VALUE;
                break;
            }
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){
                //防止溢出
                if(Math.max(dp[i-1][j], dp[i][j-1]) == Integer.MIN_VALUE){
                    continue;
                }
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + dungenon[i][j];
                if(dp[i][j] <= 0){
                    dp[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        return dp[rows-1][cols-1] >= 1;
    }



    public static int getMax(int[][] dungeon){
        int count = 0;
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dungeon[i][j]<0){
                    count -= dungeon[i][j];
                }
            }
        }
        return count+1;
    }

}
