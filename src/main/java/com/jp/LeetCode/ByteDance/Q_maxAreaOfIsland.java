package com.jp.LeetCode.ByteDance;

/**
 * @author shangqiu
 * @createTime 2020/7/23
 **/
public class Q_maxAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        if(rows == 0){
            return 0;
        }
        int cols = grid[0].length;
        boolean[][] flag = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                cleanFlag(flag);
                result = Math.max(dfs(grid, rows, cols, i, j, flag), result);
            }
        }
        return result;
    }

    public static int[] dx = new int[]{1, -1, 0, 0};
    public static int[] dy = new int[]{0, 0, 1, -1};
    public static int dfs(int[][] grid, int rows, int cols, int row, int col, boolean[][] flag){
        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0 || flag[row][col]){
            return 0;
        }
        int result = 1;
        flag[row][col] = true;
        for(int i=0;i<4;i++){
            result += dfs(grid, rows, cols, row + dx[i], col + dy[i], flag);
        }
        return result;
    }

    public static void cleanFlag(boolean[][] flag){
        int rows = flag.length;
        int cols = flag[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                flag[i][j] = false;
            }
        }
    }

    public static void test(int[][] grid, int expected){
        System.out.println(maxAreaOfIsland(grid) == expected);
    }

    public static void main(String[] args) {
        test(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
               {0,1,0,0,1,1,0,0,1,1,1,0,0},
               {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                    {0,0,0,0,0,0,0,1,1,0,0,0,0}}, 6);
        test(new int[][]{{0,0,0,0,0,0,}}, 0);
    }
}
