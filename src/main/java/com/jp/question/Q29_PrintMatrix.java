package com.jp.question;

// 29：顺时针打印矩阵
// 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
// 例如，如果输入如下4 X 4矩阵：
// 1  2  3  4
// 5  6  7  8
// 9  10 11 12
// 13 14 15 16
// 则依次打印出数字
// 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q29_PrintMatrix {

    public static ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(rows==0||cols==0)
            return new ArrayList<Integer>();

        //打印范围
        int left=0,top=0,right=cols-1,bottom=rows-1;
        while (left<=right&&top<=bottom){
            for(int i=left;i<=right;i++)
                list.add(matrix[top][i]);
            for(int i=top+1;i<=bottom;i++)
                list.add(matrix[i][right]);
            if(top<bottom)
                for(int i=right-1;i>=left;i--)
                    list.add(matrix[bottom][i]);
            if(left<right&&top<bottom-1)
                for(int i=bottom-1;i>top;i--)
                    list.add(matrix[i][left]);
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }

    public static void Test(int[][] matrix){
        List<Integer> result = printMatrix(matrix);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public static void main(String[] args){
        Test(new int[][]{{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}});
        Test(new int[][]{{1},{2},{3},{4},{5}});
        Test(new int[][]{{1,2},
                        {3,4},
                        {5,6},
                        {7,8},
                        {9,10}});
    }
}
