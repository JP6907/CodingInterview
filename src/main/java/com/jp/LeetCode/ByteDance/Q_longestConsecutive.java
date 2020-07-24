package com.jp.LeetCode.ByteDance;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author shangqiu
 * @createTime 2020/7/23
 **/
public class Q_longestConsecutive {

    public static int longestConsecutive(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        Arrays.sort(nums);
        int result = 1;
        int curr = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]+1){
                curr++;
                result = Math.max(result, curr);
            } else if(nums[i] == nums[i-1]){
                continue;
            } else {
                curr = 1;
            }
        }
        return result;
    }

    public static void test(int[] nums, int expected){
        System.out.println(longestConsecutive(nums) == expected);
    }

    public static void main(String[] args) {
        test(new int[]{100, 4, 200, 1, 3, 2}, 4);
        test(new int[]{1,2,0,1}, 3);
    }

}
