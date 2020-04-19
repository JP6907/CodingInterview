package com.jp.LeetCode.question;

//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//The robot can only move either down or right at any point in time.
// The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//How many possible unique paths are there?

//Example 1:
//
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//1. Right -> Right -> Down
//2. Right -> Down -> Right
//3. Down -> Right -> Right
//Example 2:
//
//Input: m = 7, n = 3
//Output: 28
//
//
//Constraints:
//
//1 <= m, n <= 100
//It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
//Accepted

//从做上角进入，右下角出去
//只能向下和向右走
//问有多少种路径
//动态规划:
//f(m,n)=f(m-1,n)+f(m,n-1)
public class Q62_UniquePaths {

    //递归解法
    public static int uniquePaths(int m, int n) {
        if(m==0||n==0)
            return 0;
        if(m==1||n==1)
            return 1;
        return uniquePaths(m-1,n) + uniquePaths(m,n-1);
    }

    //非递归解法
    public static int uniquePaths2(int m, int n) {
        int[][] matrix = new int[m+1][n+1];
        for(int i=0;i<m+1;i++) {
            matrix[i][0] = 0;
            matrix[i][1] = 1;
        }
        for(int i=0;i<n+1;i++) {
            matrix[0][i] = 0;
            matrix[1][i] = 1;
        }
        for(int i=2;i<m+1;i++){
            for(int j=2;j<n+1;j++){
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }
        return matrix[m][n];
    }


    public static void test(int m,int n,int expected){
        System.out.println(uniquePaths(m,n)==expected);
        System.out.println(uniquePaths2(m,n)==expected);
        System.out.println("===");
    }

    public static void main(String[] args) {
        test(3,2,3);
        test(7,3,28);
    }
}
