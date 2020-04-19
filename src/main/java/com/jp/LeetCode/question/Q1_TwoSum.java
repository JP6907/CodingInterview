package com.jp.LeetCode.question;

//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//Example:
//
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].

import java.util.Arrays;

public class Q1_TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int low = 0,high = nums.length-1;
        Arrays.sort(nums);
        int[] result = new int[2];
        while (low<high){
            int sum = nums[low] + nums[high];
            if(sum==target){
                result[0] = low;
                result[1] = high;
                break;
            }else if(sum>target){
                high--;
            }else{
                low++;
            }
        }
        return result;
    }

    public static void Test(int[] nums,int target,int[] expected){
        int[] result = twoSum(nums,target);
        System.out.println(result[0]==expected[0]&&result[1]==expected[1]);
    }

    public static void main(String[] args) {
        Test(new int[]{2, 7, 11, 15},9,new int[]{0,1});
    }

}