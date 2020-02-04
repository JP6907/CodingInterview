package com.jp.CodingInterview;

// 面试题60：n个骰子的点数
// 题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s
// 的所有可能的值出现的概率。

import java.util.ArrayList;
import java.util.List;

// n个骰子，和最小为n，最大为6×n，一共6n-n+1种和
// 和为 s 保存在 s-n 中
public class Q60_DicesProbability {

    /**
     *
     * @param number 骰子数量
     */
    static void PrintProbaility(int number){
        int maxSum = number*6;
        List<Integer> list = new ArrayList<Integer>(6*number-number+1);
        for(int i=number;i<=maxSum;i++)
            list.add(0);

        Probaility(number,0,0,list);

        double total = Math.pow(6.0,number);
        for(int i=number;i<=maxSum;i++){
            double ratio = (double)list.get(i-number)/total;
            System.out.format("%d:%e\n",i,ratio);
        }
    }
    /**
     *
     * @param origin 骰子数量
     * @param current 当前计算到第几个骰子
     * @param sum 当前累加和
     * @param nProbailities 累加结果出现的次数
     */
    static void Probaility(int origin,int current,int sum,List<Integer> nProbailities){
            if(current==origin){
                nProbailities.set(sum-origin,nProbailities.get(sum-origin)+1);
            }else{
                for(int i=1;i<=6;i++){
                    Probaility(origin,current+1,sum+i,nProbailities);
                }
            }
    }

    public static void main(String[] args){
        PrintProbaility(6);
    }
}
