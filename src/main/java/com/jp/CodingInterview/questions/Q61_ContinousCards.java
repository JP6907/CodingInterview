package com.jp.CodingInterview.questions;

// 面试题61：扑克牌的顺子
// 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
// 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。

import java.util.Arrays;

public class Q61_ContinousCards {

    static boolean IsContinuous(int[] number){
        assert number.length > 0;
        Arrays.sort(number);
        int zeroCount = 0;
        int gapCount = 0;
        //统计number中0的数量
        for(int i=0;i<number.length&&number[i]==0;i++)
            zeroCount++;
        //统计number中间隔的数量
        int small = zeroCount;
        int big = small+1;
        while(big<number.length){
            //如果相临两张牌一样，则false
            if(number[big]==number[small])
                return false;
            //间隔为相邻两张牌的数字差值大小
            gapCount += number[big]-number[small]-1;
            small = big++;
        }
        //0的数量是否大于间隔数量，是则可以为顺子
        return zeroCount>=gapCount;
    }

    public static void main(String[] args){
        assert IsContinuous(new int[]{ 1, 3, 2, 5, 4 }) == true;
        System.out.println(IsContinuous(new int[]{ 1, 3, 2, 5, 4 }));
        assert IsContinuous(new int[]{ 1, 3, 2, 6, 4 }) == false;
        System.out.println(IsContinuous(new int[]{ 1, 3, 2, 6, 4 }));
        assert IsContinuous(new int[]{ 0, 3, 2, 6, 4 }) == true;
        System.out.println(IsContinuous(new int[]{ 0, 3, 2, 6, 4 }));
        assert IsContinuous(new int[]{ 0, 3, 1, 6, 4 }) == false;
        System.out.println(IsContinuous(new int[]{ 0, 3, 1, 6, 4 }));
        assert IsContinuous(new int[]{ 1, 3, 0, 5, 0 }) == true;
        System.out.println(IsContinuous(new int[]{ 1, 3, 0, 5, 0 }));
        assert IsContinuous(new int[]{ 1, 3, 0, 7, 0 }) == false;
        System.out.println(IsContinuous(new int[]{ 1, 3, 0, 7, 0 }));
    }
}
