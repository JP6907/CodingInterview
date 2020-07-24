package com.jp.LeetCode.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author zjp
 * @createTime 2020/7/19 9:00
 **/
public class Q312_MaxCoins {

    public static void main(String[] args) {
        test(new int[]{3,1,5,8}, 167);
    }

    public static void test(int[] nums, int expected){
        int result = maxCoins(nums);
        System.out.println(result);
        System.out.println(result == expected);
    }

    public static int maxCoins(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return nums[0];
        }
        boolean[] flag = new boolean[len];
        maxCoinsCore(nums, flag, 0, nums.length-1, 0, 0);
        return result;
    }

    static int result = 0;
    public static int maxCoinsCore(int[] nums, boolean[] flag, int begin, int end, int currCoins, int count) {
        if(count == nums.length){
            return currCoins;
        }
        if(begin > end){
            return 0;
        }
        int max = 0;
        for(int i=begin;i <= end;i++){
            int score = nums[i];
            //寻找左边的气球
            int j = i-1;
            while (j>=0 && flag[j]){
                j--;
            }
            if(j >= 0){
                score *= nums[j];
            }
            //寻找右边的气球
            j = i+1;
            while (j < nums.length && flag[j]){
                j++;
            }
            if(j < nums.length){
                score *= nums[j];
            }
            flag[i] = true;
            score += maxCoinsCore(nums, flag, begin, i-1, score + currCoins, count+1);
            score += maxCoinsCore(nums, flag, i+1, end, score + currCoins, count+1);
            flag[i] = false;
            max = Math.max(max, score);
        }
        return max;
    }

}
