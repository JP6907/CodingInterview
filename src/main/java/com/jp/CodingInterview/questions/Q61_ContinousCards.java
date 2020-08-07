package com.jp.CodingInterview.questions;

// 面试题61：扑克牌的顺子
// 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
// 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。

import java.util.ArrayList;
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

    public static void test(int[] data, boolean expected){
        System.out.println(IsContinuous(data) == expected);
        System.out.println(isStraight(data) == expected);
        System.out.println("===");
    }

    public static void main(String[] args){
        test(new int[]{ 1, 3, 2, 5, 4 }, true);
        test(new int[]{ 1, 3, 2, 6, 4 }, false);
        test(new int[]{ 0, 3, 2, 6, 4 }, true);
        test(new int[]{ 0, 3, 1, 6, 4 }, false);
        test(new int[]{ 1, 3, 0, 5, 0 }, true);
        test(new int[]{ 1, 3, 0, 7, 0 }, false);
    }

    public static boolean isStraight(int[] nums) {
        if(nums.length < 2){
            return true;
        }
        //排序
        Arrays.sort(nums);
        //计算0的数量
        int zeroCount = 0;
        int nonZeroIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nonZeroIndex = i;
                break;
            }
            zeroCount++;
        }
        //计算空缺数量
        int gapCount = 0;
        for(int i=nonZeroIndex+1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                return false;
            }
            if(nums[i] != nums[i-1]+1){
                gapCount += (nums[i] - nums[i-1] - 1);
            }
        }
        return zeroCount >= gapCount;
    }
}
