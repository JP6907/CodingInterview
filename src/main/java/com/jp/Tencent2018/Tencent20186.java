package com.jp.Tencent2018;

import java.util.Scanner;

public class Tencent20186 {

    // 4 4
    //YXXB
    //XYGX
    //XBYY
    //BXXY
    // 3

    //6 5
    //XBGBX
    //YBBYB
    //BGGXX
    //XYYBG
    //XYBGG
    //YYXYX
    //对应输出应该为:
    //18
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] drawed = new char[N][M];
        char[][] drawing = new char[N][M];
        for(int i=0;i<N;i++){
            char[] colors = sc.next().toCharArray();
            for(int j=0;j<M;j++){
                drawed[i][j] = colors[j];
                drawing[i][j] = 'X';
            }
        }
        int count = 0;
        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if(drawed[i][j]!='X' && drawed[i][j]!=drawing[i][j]){
                    drawColor(drawed,drawing,N,M,i,j,drawed[i][j]);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    //从指定位置向下画
    public static void drawColor(char[][] drawed,char[][] drawing,int rows,int cols,int row,int col,char color){
        if(color=='B' || (color=='G'&&drawing[row][col]=='Y')){// /
            while (row<rows && col>=0){
                if(drawing[row][col]=='X')
                    drawing[row][col]='B'; //B
                else
                    drawing[row][col]='G'; //G
                row++;
                col--;
            }
        }else if(color=='Y' || (color=='G'&&drawing[row][col]=='B')){// \
            while (row<rows && col<cols){
                if(drawing[row][col]=='X')
                    drawing[row][col]='Y'; //Y
                else
                    drawing[row][col]='G'; //G
                row++;
                col++;
            }
        }
    }
}
