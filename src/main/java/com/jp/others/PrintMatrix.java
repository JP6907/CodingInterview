package com.jp.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//顺时针打印矩阵
public class PrintMatrix {

    public static List printMatrix(int[][] matrix){
        List<Integer> result = new ArrayList<Integer>();
        if(matrix.length==0)
            return result;
        int rows = matrix.length;
        int cols = matrix[0].length;
        //顺时针
        //右下左上
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int d = 0;
        boolean[][] flag = new boolean[rows][cols];
        int row=0,col=0;
        int tryRow=0,tryCol=0;
        for(int i=0;i<rows*cols;i++){
            result.add(matrix[row][col]);
            flag[row][col] = true;
            //尝试移动
            tryRow = row + dx[d];
            tryCol = col + dy[d];
            //需要转向
            if(tryRow<0||tryRow>=rows||tryCol<0||tryCol>=cols||flag[tryRow][tryCol]){
                d = (d+1)%4;
                tryRow = row + dx[d];
                tryCol = col + dy[d];
            }
            row = tryRow;
            col = tryCol;
        }
        return result;
    }

    public static void main(String[] args) {
        List result = printMatrix(new int[][]{{1,2,3,4,5,6},
                                            {7,8,9,10,11,12},
                                            {13,14,15,16,17,18},
                                            {19,20,21,22,23,24}});
        System.out.println(Arrays.toString(result.toArray()));
    }
}
