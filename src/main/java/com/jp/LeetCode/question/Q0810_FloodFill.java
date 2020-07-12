package com.jp.LeetCode.question;

import java.util.Arrays;

/**
 * @author zjp
 * @createTime 2020/7/4 11:14
 **/
public class Q0810_FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        if(rows == 0){
            return image;
        }
        int cols = image[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            Arrays.fill(visited[i], false);
        }
        fillCore(image, rows, cols, sr, sc, image[sr][sc], newColor, visited);
        return image;
    }

    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static void fillCore(int[][] image, int rows, int cols, int row, int col, int originColor, int newColor, boolean[][] visited){
        if(row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || image[row][col] != originColor){
            return;
        }else {
            image[row][col] = newColor;
            visited[row][col] = true;
            for(int i=0;i<4;i++){
                fillCore(image, rows, cols, row+dx[i], col+dy[i], originColor, newColor, visited);
            }
        }
    }

    public static void test(int[][] image, int sr, int sc, int newColor){
        floodFill(image, sr, sc, newColor);
        for(int i=0;i<image.length;i++){
            System.out.println(Arrays.toString(image[i]));
        }
    }

    public static void main(String[] args) {
        test(new int[][]{{1,1,1},
                        {1,1,0},
                        {1,0,1}}, 1, 1, 2);
    }

}
