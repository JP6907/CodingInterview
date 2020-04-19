package com.jp.LeetCode.question;

//Given a m x n grid filled with non-negative numbers,
// find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
//Note: You can only move either down or right at any point in time.
//
//Example:
//
//Input:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//Output: 7
//Explanation: Because the path 1→3→1→1→1 minimizes the sum.

//只能往下或往右走
//动态规划，记忆化搜索
//f(m,n) = grid[m,n]+Min(f(m-1,n),f(m,n-1))
public class Q64_MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        if(row==0)
            return 0;
        int col = grid[0].length;
        if(col==0)
            return 0;
        return minPathSumCore(grid,row-1,col-1);
    }
    //递归解法
    public static int minPathSumCore(int[][] grid,int row,int col){
        if(row==0&&col==0)
            return grid[0][0];
        if(row==0)
            return minPathSumCore(grid,0,col-1)+grid[0][col];
        if(col==0)
            return minPathSumCore(grid,row-1,0)+grid[row][0];
        return grid[row][col] + Math.min(minPathSumCore(grid,row-1,col),minPathSumCore(grid,row,col-1));
    }

    //记忆化解法
    public static int minPathSum2(int[][] grid){
        int row = grid.length;
        if(row==0)
            return 0;
        int col = grid[0].length;
        if(col==0)
            return 0;
        int[][] pathLen = new int[row][col];
        pathLen[0][0] = grid[0][0];
        for(int i=1;i<col;i++)
            pathLen[0][i] = pathLen[0][i-1] + grid[0][i];
        for(int i=1;i<row;i++)
            pathLen[i][0] = pathLen[i-1][0] + grid[i][0];
        for(int i=1;i<row;i++){
            for (int j=1;j<col;j++){
                pathLen[i][j] = grid[i][j] + Math.min(pathLen[i-1][j],pathLen[i][j-1]);
            }
        }
        return pathLen[row-1][col-1];
    }

    public static void test(int[][] grid,int expected){
        System.out.println(minPathSum(grid)==expected);
        System.out.println(minPathSum2(grid)==expected);
        System.out.println("===");
    }

    public static void main(String[] args) {
        test(new int[][]{{1,3,1},{1,5,1},{4,2,1}},7);
    }
}
