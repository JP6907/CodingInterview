package com.jp.LeetCode.ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * @author shangqiu
 * @createTime 2020/7/23
 **/
public class Q_findLengthOfLCIS {

    public static int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return len;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1;i<len;i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
                max = Math.max(max, dp[i]);
            }else {
                dp[i] = 1;
            }
        }
        return max;
    }

    public static void test(int[] nums, int expected){
        System.out.println(findLengthOfLCIS(nums) == expected);
    }

    public static void main(String[] args) {
        test(new int[]{1,3,5,4,7}, 3);
        test(new int[]{2,2,2,2,2}, 1);
    }

}
