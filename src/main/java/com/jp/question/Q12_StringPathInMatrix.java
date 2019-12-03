package com.jp.question;

// 面试题12：矩阵中的路径
// 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
// 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
// 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
// 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
// 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
// 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
// A B T G
// C F C S
// J D E H

import java.util.Arrays;

public class Q12_StringPathInMatrix {

    static boolean hasPath(char[][] matrix,int rows,int cols,String str){
        boolean[][] isVisited = new boolean[rows][cols];
        int pathLength = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(hasPathCore(matrix,rows,cols,i,j,str,pathLength,isVisited))
                    return true;
            }
        }
        return false;
    }

    /**
     * 回溯法
     * @param matrix 矩阵
     * @param rows 行数
     * @param cols 列数
     * @param row 当前行号
     * @param col 当前列号
     * @param str 目标字符串
     * @param pathLength 当前已走路径长度
     * @param isVisited 标记每个格子是否已经被访问
     * @return
     */
    static boolean hasPathCore(char[][] matrix,int rows,int cols,int row,int col,String str,int pathLength,boolean[][] isVisited){
        if(pathLength == str.length())
            return true;
        if(row<0 || row>=rows || col<0 || col>= cols || isVisited[row][col]==true)
            return false;
        if(matrix[row][col] == str.charAt(pathLength)){
            pathLength++;
            isVisited[row][col] = true;
            boolean result = hasPathCore(matrix,rows,cols,row-1,col,str,pathLength,isVisited)
                    || hasPathCore(matrix,rows,cols,row+1,col,str,pathLength,isVisited)
                    || hasPathCore(matrix,rows,cols,row,col-1,str,pathLength,isVisited)
                    || hasPathCore(matrix,rows,cols,row,col+1,str,pathLength,isVisited);
            //回退，清除脚印
            if(!result)
                isVisited[row][col] = false;
            return result;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        char[][] matrix = {{'a','b','t','g'},
                            {'c','f','c','s'},
                            {'j','d','e','h'}};
        System.out.println(hasPath(matrix,3,4,"abfd"));
        System.out.println(hasPath(matrix,3,4,"abfe"));
        System.out.println(hasPath(matrix,3,4,"bbbb"));
    }
}
