package com.jp.LeetCode.question;

//Given a 2D board and a word, find if the word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//Example:
//
//board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//Given word = "ABCCED", return true.
//Given word = "SEE", return true.
//Given word = "ABCB", return false.

public class Q79_WordSearch {

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                boolean[][] flag = new boolean[rows][cols];
                if(existDFS(board,word,i,j,rows,cols,0,flag))
                    return true;
            }
        }
        return false;
    }

    public static boolean existDFS(char[][] board,String word,int row,int col,int rows,int cols,int index,boolean[][] flag){
        if(index==word.length())
            return true;
        if(row<0||row>=rows||col<0||col>=cols)
            return false;
        if(!flag[row][col]&&word.charAt(index)==board[row][col]) {
            flag[row][col] = true;
            boolean result =  existDFS(board, word, row + 1, col, rows, cols, index + 1, flag)
                        || existDFS(board, word, row - 1, col, rows, cols, index + 1, flag)
                        || existDFS(board, word, row, col + 1, rows, cols, index + 1, flag)
                        || existDFS(board, word, row, col - 1, rows, cols, index + 1, flag);
            if(!result) {
                flag[row][col] = false;
                return false;
            }
            return true;
        }
        return false;
    }

    public static void test(char[][] board, String word,boolean expected){
        System.out.println(exist(board,word)==expected);
    }

    public static void main(String[] args) {
        test(new char[][]{{'a'}},"a",true);
        char[][] board = new char[][]{ {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}};
        test(board,"ABCCED",true);
        test(board,"SEE",true);
        test(board,"ABCB",false);
    }
}
