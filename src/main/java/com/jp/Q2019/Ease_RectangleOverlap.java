package com.jp.Q2019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 题目描述
//  平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]), 右上角坐标为(x2[i], y2[i])。
//  如果两个或者多个矩形有公共区域则认为它们是相互重叠的(不考虑边界和角落)。
//  请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互重叠。
//
//输入描述:
//  输入包括五行。
//  第一行包括一个整数n(2 <= n <= 50), 表示矩形的个数。
//  第二行包括n个整数x1[i](-10^9 <= x1[i] <= 10^9),表示左下角的横坐标。
//  第三行包括n个整数y1[i](-10^9 <= y1[i] <= 10^9),表示左下角的纵坐标。
//  第四行包括n个整数x2[i](-10^9 <= x2[i] <= 10^9),表示右上角的横坐标。
//  第五行包括n个整数y2[i](-10^9 <= y2[i] <= 10^9),表示右上角的纵坐标。
// 输出描述:
//  输出一个正整数, 表示最多的地方有多少个矩形相互重叠,如果矩形都不互相重叠,输出1。
//示例1
//输入
//2
//0 90
//0 90
//100 200
//100 200
//输出
//2
public class Ease_RectangleOverlap {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int point[][] = new int[N][4];
        //左下角的横坐标
        for(int i=0;i<N;i++){
            point[i][0] = sc.nextInt();
        }
        //左下角的纵坐标
        for(int i=0;i<N;i++){
            point[i][1] = sc.nextInt();
        }
        //右上角的横坐标
        for(int i=0;i<N;i++){
            point[i][2] = sc.nextInt();
        }
        //右上角的纵坐标
        for(int i=0;i<N;i++){
            point[i][3] = sc.nextInt();
        }
        Arrays.sort(point, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //按左下角横坐标排序
                return o1[0]-o2[0];
            }
        });
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=1;j<N;j++){
                if(point[i][2]>point[j][0] && ((point[j][1]<point[i][3]&&point[j][1]>point[i][1])
                        || (point[j][3]>point[i][1]&&point[j][3]<point[i][3])))
                    count++;
            }
        }
        System.out.println(count);

    }
}
