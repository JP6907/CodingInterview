package com.jp.question;

// 面试题47：礼物的最大价值
// 题目：在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值
// （价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或
// 者向下移动一格直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计
// 算你最多能拿到多少价值的礼物？
public class Q47_MaxValueOfGifts {
    //典型的动态规划问题
    //f(i,j)表示(i,j)能拿到的礼物的总和的最大值，依赖于f(i-1,j)和f(i,j-1)
    static int getMaxValue_solution1(int[][] values,int rows,int cols){
        int[][] f = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int up = 0;
                int left = 0;
                if(i>0)
                    up = f[i-1][j];
                if(j>0)
                    left = f[i][j-1];
                f[i][j] = Math.max(up,left) + values[i][j];
            }
        }
        return f[rows-1][cols-1];
    }

    public static void main(String[] args){
        int[][] values = {{1,10,3,8},
                            {12,2,9,6},
                            {5,7,4,11},
                            {3,7,16,5}};
        //1->12->5->7->7->16->5
        assert getMaxValue_solution1(values,4,4) == 53;
    }

}
