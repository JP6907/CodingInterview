package com.jp.CodingInterview.questions;


// 13：机器人的运动范围
// 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
// 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
// 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
// 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

import java.util.Arrays;

public class Q13_RobotMove {

    // 回溯法
    public static int movingCount(int threshold, int rows, int cols){
        if(threshold<0)
            return 0;
        boolean[] isVisited = new boolean[rows*cols];
        for(int i=0;i<isVisited.length;i++)
            isVisited[i] = false;
        return movingCountCore(threshold,rows,cols,0,0,isVisited);
    }

    public static int movingCountCore(int threadshold,int rows,int cols,int row,int col,boolean[] isVisited){
        if(row>=rows || row<0 || col>=cols || col<0 || isVisited[row*cols+col] || DigitSum(row,col)>threadshold){
            return 0;
        }else{
            isVisited[row*cols+col] = true;
            return 1 + movingCountCore(threadshold,rows,cols,row+1,col,isVisited)
                    + movingCountCore(threadshold,rows,cols,row-1,col,isVisited)
                    + movingCountCore(threadshold,rows,cols,row,col+1,isVisited)
                    + movingCountCore(threadshold,rows,cols,row,col-1,isVisited);

        }
    }

    //获取两个数字的数位和
    //(35, 37) => 3+5+3+7=18
    public static int DigitSum(int num1,int num2){
        int sum = 0;
        while (num1!=0){
            sum += num1%10;
            num1 /= 10;
        }
        while (num2!=0){
            sum += num2%10;
            num2 /= 10;
        }
        return sum;
    }

    public static void Test(int threshold, int rows, int cols,int expected){
        System.out.println(movingCount(threshold,rows,cols)==expected);
        System.out.println(movingCount2(rows,cols,threshold)==expected);
    }

    public static void main(String[] args){
        Test(5, 10, 10, 21);
        Test(15, 20, 20, 359);
        Test(10, 1, 100, 29);
        Test(10, 1, 10, 10);
        Test(15, 100, 1, 79);
        Test(15, 10, 1, 10);
        Test(15, 1, 1, 1);
        Test(0, 1, 1, 1);
        Test(-10, 10, 10, 0);

    }

    public static int movingCount2(int m, int n, int k) {
        if(m<=0 || n<=0 || k<0)
            return 0;
        boolean[][] flag = new boolean[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(flag[i], false);
        }
        return movingCountCore2(m, n, k, 0, 0, flag);
    }

    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    public static int movingCountCore2(int rows,int cols,int k, int row, int col, boolean[][] flag){
        if(row<0 || row>=rows || col<0 || col>=cols || flag[row][col]){
            return 0;
        }
        if(!check(row,col,k)){
            return 0;
        }
        flag[row][col] = true;
        int count = 1;
        for(int i=0;i<4;i++){
            count += movingCountCore2(rows, cols, k, row+dx[i], col+dy[i], flag);
        }
        return count;
    }

    public static boolean check(int row,int col,int threadshold){
        if(getDigitSum(row)+getDigitSum(col)<=threadshold) {
            return true;
        }else {
            return false;
        }
    }

    public static int getDigitSum(int number){
        int sum = 0;
        while (number>0){
            sum += number%10;
            number /= 10;
        }
        return sum;
    }
}
