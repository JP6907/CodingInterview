package com.jp.Q2020;

import java.util.Arrays;
import java.util.Scanner;

public class WangYi4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        int[][] dp = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                dp[i][j] = -1;
        }
        for(int i=0;i<n;i++){
            String line = sc.next();
            for(int j=0;j<m;j++){
                matrix[i][j] = Integer.parseInt(line.charAt(j)+"");
                if(matrix[i][j]==0)
                    dp[i][j] = 0;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                calcule(matrix,i,j,n,m,dp,visited);
        }
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int calcule(int[][] matrix,int row,int col,int rows,int cols,int[][] dp,boolean[][] visited){
        if(row<0||row>=rows||col<0||col>=cols||visited[row][col])
            return Integer.MAX_VALUE;
        if(dp[row][col]!=-1)
            return dp[row][col];
        visited[row][col] = true;
        int min = min4(calcule(matrix,row+1,col,rows,cols,dp,visited),
                        calcule(matrix,row-1,col,rows,cols,dp,visited),
                        calcule(matrix,row,col+1,rows,cols,dp,visited),
                        calcule(matrix,row,col-1,rows,cols,dp,visited))+1;
        dp[row][col] = min;
        visited[row][col] = false;
        return min;
    }

    public static int min4(int n1,int n2,int n3,int n4){
        return Math.min(Math.min(n1,n2),Math.min(n3,n4));
    }
}
