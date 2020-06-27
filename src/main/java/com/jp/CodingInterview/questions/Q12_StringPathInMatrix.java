package com.jp.CodingInterview.questions;

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

    //回溯法
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        boolean[] isVisited = new boolean[rows*cols];
        for(int i=0;i<isVisited.length;i++)
            isVisited[i] = false;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(hasPathCore(matrix,rows,cols,i,j,str,0,isVisited))
                    return true;
            }
        }
        return false;
    }

    /**
     *
     * @param matrix
     * @param rows
     * @param cols
     * @param row 当前行号
     * @param col 当前列号
     * @param str
     * @param index 当前在str中的位置
     * @param isVisited
     * @return
     */
    public static boolean hasPathCore(char[] matrix,int rows,int cols,int row,int col,char[] str,int index,boolean[] isVisited){
        if(index==str.length)
            return true;
        if(row<rows && row>=0
                && col<cols && col>=0 && isVisited[row*cols+col]!=true){
            if(matrix[row*cols+col]!=str[index]){
                return false;
            }else {
                isVisited[row * cols + col] = true;
                boolean result =  hasPathCore(matrix,rows,cols,row+1,col,str,index+1,isVisited)
                            || hasPathCore(matrix,rows,cols,row-1,col,str,index+1,isVisited)
                            || hasPathCore(matrix,rows,cols,row,col+1,str,index+1,isVisited)
                            || hasPathCore(matrix,rows,cols,row,col-1,str,index+1,isVisited);
                if(!result) //清除脚印
                    isVisited[row*cols+col] = false;
                return result;
            }
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
        System.out.println(exist(matrix,"abfd"));
        System.out.println(exist(matrix,"abfe"));
        System.out.println(exist(matrix,"bbbb"));

        System.out.println("======");
        char[] path = new char[]{'a','b','t','g',
                                 'c','f','c','s',
                                 'j','d','e','h'};
        System.out.println(hasPath(path,3,4,"abfd".toCharArray()));
        System.out.println(hasPath(path,3,4,"abfe".toCharArray()));
        System.out.println(hasPath(path,3,4,"bbbb".toCharArray()));

        //ABCE
        //SFCS
        //ADEE
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(),3,4,"SEE".toCharArray()));
    }


    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        if(rows==0)
            return false;
        int cols = board[0].length;
        boolean[][] flag = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            Arrays.fill(flag[i], false);
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(existHelper(board, rows, cols, word, 0, i, j, flag))
                    return true;
            }
        }
        return false;
    }

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static boolean existHelper(char[][] board, int rows, int cols, String word, int index, int row, int col, boolean[][] flag){
        if(index==word.length()){
            return true;
        }else if(row<0 || row>=rows || col<0 || col>=cols){
            return false;
        }else if(flag[row][col] || board[row][col]!=word.charAt(index)){
            return false;
        }else {
            flag[row][col] = true;
            boolean result = false;
            for(int i=0;i<4;i++){
                if(existHelper(board, rows, cols, word, index+1, row+dx[i], col+dy[i], flag)){
                    result = true;
                    break;
                }
            }

//            flag[row][col] = true;
//            boolean result = existHelper(board, rows, cols, word, index+1, row+1, col, flag)
//                        || existHelper(board, rows, cols, word, index+1, row-1, col, flag)
//                        || existHelper(board, rows, cols, word, index+1, row, col+1, flag)
//                        || existHelper(board, rows, cols, word, index+1, row, col-1, flag);
            if(result) {
                return true;
            }else {
                flag[row][col] = false;
                return false;
            }
        }

    }
}
