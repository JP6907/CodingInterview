package com.jp.question;


// 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
// 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
// 整数，判断数组中是否含有该整数。
public class Q04_FindInPartiallySortedMatrix {

    static boolean Find(int[][] array, int target) {
        int rows = array.length;
        int columns = array[0].length;
        if (rows <= 0 || columns <= 0)
            return false;
        int row = 0;
        int col = columns-1;
        while(row<rows && col>=0){
            if(array[row][col]==target)
                return true;
            if(array[row][col]>target)
                col--;
            else
                row++;
        }
        return false;
    }

    public static void main(String[] args){
        //  1   2   8   9
        //  2   4   9   12
        //  4   7   10  13
        //  6   8   11  15
        //true
        System.out.println(Find(new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}},
                        7));
        //false
        System.out.println(Find(new int[][] {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}},
                 5));
        //true
        System.out.println(Find(new int[][] {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}},
                 1));
        //true
        System.out.println(Find(new int[][] {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}},
                 15));

        System.out.println(Find(new int[][] {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}},
                0));
    }
}