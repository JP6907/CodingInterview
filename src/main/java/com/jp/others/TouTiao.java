package com.jp.others;

//头条的2017校招开始了！为了这次校招，我们组织了一个规模宏大的出题团队。
// 每个出题人都出了一些有趣的题目，而我们现在想把这些题目组合成若干场考试出来。
// 在选题之前，我们对题目进行了盲审，并定出了每道题的难度系数。一场考试包含3道开放性题目，
// 假设他们的难度从小到大分别为a, b, c，我们希望这3道题能满足下列条件：
//
//a＜= b＜= c
//b - a＜= 10
//c - b＜= 10
//
//所有出题人一共出了n道开放性题目。现在我们想把这n道题分布到若干场考试中
// 1场或多场，每道题都必须使用且只能用一次），然而由于上述条件的限制，可能有一些考试没法凑够3道题，
// 因此出题人就需要多出一些适当难度的题目来让每场考试都达到要求。然而我们出题已经出得很累了，你能计算出我们最少还需要再出几道题吗？

//输入
//输入的第一行包含一个整数n，表示目前已经出好的题目数量。
//
//第二行给出每道题目的难度系数 d1, d2, …, dn。
//
//样例输入
//4
//
//20 35 23 40

import java.util.Arrays;
import java.util.Scanner;

//输出
//输出只包括一行，即所求的答案。
//
//样例输出
//2
public class TouTiao {
    //每道题都 必须使用 且 只能用一次
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] diff = new int[n];
        for(int i=0;i<n;i++)
            diff[i] = sc.nextInt();
        //排序
        Arrays.sort(diff);
        //题目是否已经被选过
        boolean[] flag = new boolean[n];
        //按照最紧凑的方法进行选题
        //b=a+10
        //c=b+10
        int add = 0; //需要增加的题数
        int selected = 0; //已经被选中的数量
        //每次从第一个还未被选中的题目开始，往后取3个
        while (true){
            int count = 0;
            int lastDiff = -10;
            for(int i=0;i<n;i++){
                if(!flag[i]&&diff[i]-lastDiff>=10){
                    flag[i] = true;
                    count++;
                    selected++;
                }
                if(count==3)
                    break;
            }
            if(count!=3)
                add += (3-count);
            if(selected==n)
                break;
        }
        System.out.println(add);
    }
}
