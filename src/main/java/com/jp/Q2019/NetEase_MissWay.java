package com.jp.Q2019;

// 题目描述
//牛牛去犇犇老师家补课，出门的时候面向北方，但是现在他迷路了。
// 虽然他手里有一张地图，但是他需要知道自己面向哪个方向，请你帮帮他。

import java.util.Scanner;

// 输入描述:
//  每个输入包含一个测试用例。
//  每个测试用例的第一行包含一个正整数，表示转方向的次数N(N<=1000)。
//  接下来的一行包含一个长度为N的字符串，由L和R组成，L表示向左转，R表示向右转。
//输出描述:
//  输出牛牛最后面向的方向，N表示北，S表示南，E表示东，W表示西。
//示例1
//输入
//  3
//  LRR
//输出
//  E
public class NetEase_MissWay {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        String turn = sc.next();
        int count = 0;
        for(int i=0;i<length;i++){
            if(turn.charAt(i)=='L')
                count--;
            else
                count++;
        }
        count = count%4;
        if(count<0)
            count += 4;
        String finalDirection = "N";
        switch (count){
            case 0 : finalDirection = "N"; break;
            case 1 : finalDirection = "E"; break;
            case 2 : finalDirection = "S"; break;
            case 3 : finalDirection = "W"; break;
        }
        System.out.println(finalDirection);
    }
}
